mcCarthy :: Integral a => [a]->[a]
mcCarthy [] = []
mcCarthy (x:xs)
    | x>100 = [x-10] ++ mcCarthy xs
    | otherwise = [91] ++ mcCarthy xs
    
