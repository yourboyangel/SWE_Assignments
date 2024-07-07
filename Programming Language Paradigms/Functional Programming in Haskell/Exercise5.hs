sumOfSquares :: (Num a)=> [a]->a
sumOfSquares []=0
sumOfSquares xs = sum[(x*x)|x<-xs]
