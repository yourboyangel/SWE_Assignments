import com.sun.source.tree.Tree;

// Exercise 4
public class TrimBinarySearchTree {
    public TreeNode trim(TreeNode root, int low, int high){
        if(root==null) return null;
        if(root.val<low) return trim(root.right, low, high);
        if(root.val>high) return trim(root.left, low, high);

        root.left=trim(root.left, low, high);
        root.right=trim(root.right, low, high);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left= new TreeNode(0);
        root.right=new TreeNode(2);
        TrimBinarySearchTree trimmed = new TrimBinarySearchTree();
        TreeNode trimmedTree = trimmed.trim(root,1,2);
        System.out.println(trimmedTree);

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(0);
        root2.right = new TreeNode(4);
        root2.left.right = new TreeNode(2);
        root2.left.right.left = new TreeNode(1);
        TreeNode trimmedTree2 = trimmed.trim(root2, 1, 3);
        System.out.println(trimmedTree2);
    }
}
