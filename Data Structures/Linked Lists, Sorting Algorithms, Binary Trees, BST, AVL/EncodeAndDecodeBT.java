import java.util.LinkedList;
import java.util.Queue;

//Exercise 2
public class EncodeAndDecodeBT {
    public static String encode(TreeNode root){
        StringBuilder s = new StringBuilder();
        encodeHelper(root,s);
        return s.toString();
    }

    public static void encodeHelper(TreeNode node, StringBuilder s){
        if(node==null){
            return;
        }
        s.append(node.val).append(",");
        encodeHelper(node.left,s);
        encodeHelper(node.right,s);
    }

    public static TreeNode decode(String s){
        if(s.isEmpty()) return null;
        String[] values = s.split(",");
        Queue<Integer> q = new LinkedList<>();
        for(String value : values){
            q.offer(Integer.parseInt(value));
        }
        return decodeHelper(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static TreeNode decodeHelper(Queue<Integer>q, int min, int max ){
        if(q.isEmpty()) return null;
        int  value=q.peek();
        if(value<min || value>max){
            return null;
        }
        q.poll();
        TreeNode node = new TreeNode(value);
        node.left=decodeHelper(q,min,value);
        node.right=decodeHelper(q,value, max);
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left=new TreeNode(1);
        root.right= new TreeNode(3);
        String encodedTree = encode(root);
        System.out.println("Encoded Tree: "+encodedTree);
        TreeNode decodedRoot=decode(encodedTree);
        System.out.println("Decoded Tree: "+decodedRoot.val);

    }
}
