multiply :: Integral a => a->a->a
multiply 0 _ = 0
multiply _ 0 = 0
multiply x y 
    | y>0 = x + multiply x (y-1)
    | otherwise = negate $ multiply x (-y)
