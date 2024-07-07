//Exercise 1
public class CountNodes {
    public static int maxNodesHelper(TreeNode node, int maxUntilNow){
        if(node==null){
            return 0;
        }
        int maxCnt=0;
        if(node.val>=maxUntilNow){
            maxCnt=1;
            maxUntilNow=node.val;
        }
        maxCnt+=maxNodesHelper(node.left, maxUntilNow);
        maxCnt+=maxNodesHelper(node.right, maxUntilNow);

        return maxCnt;
    }
    public static int maxNodes(TreeNode root){
        return maxNodesHelper(root, 0);
    }

    public static void main(String[] args) {
        TreeNode root= new TreeNode(3);
        root.left=new TreeNode(1);
        root.right=new TreeNode(4);
        root.left.left= new TreeNode(3);
        root.right.left=new TreeNode(1);
        root.right.right=new TreeNode(5);

        System.out.println(maxNodes(root));
    }

}
