data BinaryTree a = EmptyTree | Node a (BinaryTree a) (BinaryTree a) deriving (Show, Read, Eq)

preorder :: BinaryTree a-> [a]
preorder EmptyTree=[]
preorder (Node x left right)=x: preorder left ++ preorder right

inorder :: BinaryTree a -> [a]
inorder EmptyTree = []
inorder (Node x left right)=inorder left ++ [x] ++ inorder right

postorder :: BinaryTree a -> [a]
postorder EmptyTree = []
postorder (Node x left right)= postorder left ++ postorder right ++ [x]