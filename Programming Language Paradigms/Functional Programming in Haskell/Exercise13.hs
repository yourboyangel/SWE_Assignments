foldr' :: (a->a->a) -> a -> [a] ->a
foldr' _ x [] = x
foldr' f x (y:xs)=f x (foldr' f y xs)

foldl' :: (a->a->a) -> a -> [a] ->a
foldl' _ x [] = x
foldl' f x (y:xs) = f(foldl' f y xs)x