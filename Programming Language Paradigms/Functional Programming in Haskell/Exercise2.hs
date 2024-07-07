absoluteValue :: (Num a, Ord a)=>a->a
absoluteValue a = if (a<0) then a*(-1) else a
