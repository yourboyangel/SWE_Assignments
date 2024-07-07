import io
import socket

class MicroSerializer:
    UNSERIALIZABLE_TYPES = {io.IOBase, socket.socket}

    def __init__(self):
        self.seen = set()

    def serialize_dict(self, dictionary):
        print()
        for key, value in dictionary.items():
            if not isinstance(value, (int, float, str, list, tuple, set)):
                if any(isinstance(value, t) for t in MicroSerializer.UNSERIALIZABLE_TYPES):
                    self.seen.clear()
                    raise Exception("Object has unserializable members")
                temp = value
                if not isinstance(value, dict):
                    if value in self.seen:
                        self.seen.clear()
                        raise Exception("Cyclical references detected. Serialization rejected.")
                    self.seen.add(value)
                    temp = vars(value)
                    temp['___class___'] = value.__class__.__name__
                dictionary[key] = self.serialize_dict(temp)
            elif isinstance(value, (list, tuple, set)):
                dictionary[key] = self.serialize_list(value)
        return dictionary

    def serialize_list(self, lst):
        for i in range(len(lst)):
            if isinstance(lst[i], (list, tuple, set)):
                lst[i] = self.serialize_list(lst[i])
            elif not isinstance(lst[i], (int, float, str, list, tuple, set)):
                temp = lst[i]
                if not isinstance(lst[i], dict):
                    temp = vars(lst[i])
                    temp['___class___'] = lst[i].__class__.__name__
                temp = self.serialize_dict(temp)
                lst[i] = temp
        return lst

    def serialize(self, obj):
        if not isinstance(obj, (int, float, str, list, tuple, set)):
            if not isinstance(obj, dict):
                if any(isinstance(obj, t) for t in MicroSerializer.UNSERIALIZABLE_TYPES):
                    self.seen.clear()
                    raise Exception("Object is unserializable")
                serialized_obj = vars(obj)
                serialized_obj['___class___'] = obj.__class__.__name__
                serialized_obj = self.serialize_dict(serialized_obj)
            else:
                serialized_obj = self.serialize_dict(obj)
        elif isinstance(obj, (list, tuple, set)):
            serialized_obj = self.serialize_list(obj)
        self.seen.clear()
        return str(serialized_obj)

    def deserialize_dict(self, serialized_dict):
        if isinstance(serialized_dict, dict) and '___class___' in serialized_dict:
            class_name = serialized_dict['___class___']
            class_obj = globals()[class_name]
            del serialized_dict['___class___']
            obj = class_obj.__new__(class_obj)
            class_obj.__init__(obj, *(), **{})
            for key, value in serialized_dict.items():
                if isinstance(value, (list, tuple, set)):
                    setattr(obj, key, self.deserialize_list(value))
                else:
                    setattr(obj, key, self.deserialize_dict(value))
            return obj
        elif isinstance(serialized_dict, dict):
            for key, value in serialized_dict.items():
                if isinstance(value, (list, tuple, set)):
                    serialized_dict[key] = self.deserialize_list(value)
                else:
                    serialized_dict[key] = self.deserialize_dict(value)
        return serialized_dict

    def deserialize_list(self, serialized_list):
        for i in range(len(serialized_list)):
            if isinstance(serialized_list[i], (list, tuple, set)):
                serialized_list[i] = self.deserialize_list(serialized_list[i])
            else:
                serialized_list[i] = self.deserialize_dict(serialized_list[i])
        return serialized_list

    def deserialize(self, serialized_obj):
        serialized = eval(serialized_obj)
        if isinstance(serialized, (list, tuple, set)):
            return self.deserialize_list(serialized)
        return self.deserialize_dict(serialized)

class X:
    def __init__(self):
        self.identifier = "Object X"
        self.number = 123

class Y:
    def __init__(self):
        self.active = True
        self.items = ['Benz', 'BMW', 'Toyota']

class Z:
    def __init__(self):
        self.active = False
        self.x_obj = X()
        self.y_obj = Y()

class W:
    def __init__(self):
        self.identifier = "Object W"
        self.z_obj = Z()

if __name__ == '__main__':
    serializer = MicroSerializer()

    w_obj = W()

    
    serialized_data = serializer.serialize(w_obj)
    print("Serialized Data:")
    print(serialized_data)

   
    deserialized_data = serializer.deserialize(serialized_data)
    print("\nDeserialized Data:")
    print(deserialized_data.identifier)
    print(deserialized_data.z_obj.active)
    print(deserialized_data.z_obj.x_obj.number)
    print(deserialized_data.z_obj.y_obj.items)


