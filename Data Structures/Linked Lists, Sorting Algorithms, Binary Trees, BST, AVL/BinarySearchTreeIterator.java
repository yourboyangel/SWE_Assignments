import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

//Exercise 3
public class BinarySearchTreeIterator implements Iterator<Integer> {
    private Stack<TreeNode> stack;


    public BinarySearchTreeIterator(TreeNode root){
        stack=new Stack<>();
        pushLeft(root);
    }

    private void pushLeft(TreeNode node){
        while(node!=null){
            stack.push(node);
            node=node.left;
        }
    }
    @Override
    public boolean hasNext(){
        return !stack.isEmpty();
    }

   @Override
    public Integer next(){
        if(!hasNext()){
            throw new NoSuchElementException("Empty Tree");
        }
        TreeNode node=stack.pop();
        if(node.right!=null){
            pushLeft(node.right);
        }
        return node.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        BinarySearchTreeIterator itr = new BinarySearchTreeIterator(root);
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

    }

}
