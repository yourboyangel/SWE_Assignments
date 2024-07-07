class Node:
    def __init__(self, key, value):
        self.key=key
        self.value=value
        self.prev=None
        self.next=None

class LRUCache:
    def __init__(self, size):
        self.size=size
        self.cache={}
        self.head=Node(None,None)
        self.tail=Node(None, None)
        self.head.next=self.tail
        self.tail.prev=self.head

    def move_to_front(self, node):
        node.prev.next=node.next
        node.next.prev=node.prev
        node.prev=self.head
        node.next=self.head.next
        self.head.next.prev=node
        self.head.next=node
    
    def get(self, key):
        if key not in self.cache:
            return None
        node=self.cache[key]
        self.move_to_front(node)
        return node.value
    
    def put(self, key, value):
        if key in self.cache:
            node=self.cache[key]
            node.value=value
            self.move_to_front(node)
        else:
            if len(self.cache)==self.size:
                delete_node=self.tail.prev
                delete_node.prev.next=self.tail
                self.tail.prev=delete_node.prev
                del self.cache[delete_node.key]
            new_node=Node(key, value)
            self.cache[key]=new_node
            new_node.prev=self.head
            new_node.next=self.head.next
            self.head.next.prev=new_node
            self.head.next=new_node

def main():
    cache=LRUCache(2)
    cache.put(1,1)
    cache.put(2,2)
    print(cache.get(1))
    cache.put(3,3)
    print(cache.get(2))
    cache.put(4,4)
    print(cache.get(1))
    print(cache.get(3))
    print(cache.get(4))

if __name__=="__main__":
    main()