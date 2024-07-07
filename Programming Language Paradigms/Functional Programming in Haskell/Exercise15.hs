type Col = Int
type Row = Int
type KnightPos = (Col, Row)

knightMoves :: KnightPos -> [KnightPos]
knightMoves (c, r) = filter onBoard [(c+2,r-1),(c+2,r+1),(c-2,r-1),(c-2,r+1),(c+1,r-2),(c+1,r+2),(c-1,r-2),(c-1,r+2)]
    where onBoard (c', r') = c' `elem` [1..8] && r' `elem` [1..8]

canReachIn3 :: KnightPos -> KnightPos -> Bool
canReachIn3 start finish = finish `elem` knightMoves3 start
    where 
        knightMoves3 :: KnightPos -> [KnightPos]
        knightMoves3 pos = do
            m1 <- knightMoves pos
            m2 <- knightMoves m1 
            knightMoves m2 

