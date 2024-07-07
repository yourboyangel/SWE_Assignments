myAny :: [a]->(a->Bool)->Bool
myAny []_=False
myAny (x:xs) f = f x || myAny xs f