myAnd :: [Bool]->Bool
myAnd xs = foldr (&&) True xs
