//PS: I copied the methods for printing the tree from GitHub
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public String toString() {
        if (this == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(RED_COLOR).append(val).append(RESET_COLOR);

        String pointerRight = BLUE_COLOR + "R└──>" + RESET_COLOR;
        String pointerLeft = (right != null) ? "L├──>" : "L└──>";
        pointerLeft = YELLOW_COLOR + pointerLeft + RESET_COLOR;

        traverseNodes(sb, "", pointerLeft, left, right != null);
        traverseNodes(sb, "", pointerRight, right, false);

        return sb.toString();
    }

    void traverseNodes(StringBuilder sb, String padding, String pointer, TreeNode node,
                       boolean hasRightSibling) {
        if (node != null) {
            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.val);

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append(" │  ");
            } else {
                paddingBuilder.append("    ");
            }

            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = BLUE_COLOR + "R└──>" + RESET_COLOR;
            String pointerLeft = (node.right != null) ? "L├──>" : "L└──>";
            pointerLeft = YELLOW_COLOR + pointerLeft + RESET_COLOR;

            traverseNodes(sb, paddingForBoth, pointerLeft, node.left, node.right != null);
            traverseNodes(sb, paddingForBoth, pointerRight, node.right, false);
        }
    }

    private static final String YELLOW_COLOR = "\u001B[33m";
    private static final String BLUE_COLOR = "\u001B[34m";
    private static final String RESET_COLOR = "\u001B[0m";
    private static final String RED_COLOR = "\033[1;31m";
}