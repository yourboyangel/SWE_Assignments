myFilter :: (a->Bool)->[a]->[a]
myFilter _ [] = []
myFilter f (x:xs)=foldr (\x acc -> if f x then x: acc else acc)[]xs