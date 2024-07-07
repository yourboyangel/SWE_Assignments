applyTimes :: (Eq a, Num a)=>a->(b->b)->b->b 
applyTimes 0 _ x = x 
applyTimes a f b = f(applyTimes(a-1) f b)