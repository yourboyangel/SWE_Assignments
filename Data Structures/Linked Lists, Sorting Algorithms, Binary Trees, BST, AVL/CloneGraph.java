import java.util.HashMap;
import java.util.Map;
//Exercise 11

public class CloneGraph {
    public Node clone(Node node){
        if(node == null) return null;

        Map<Node, Node>visited= new HashMap<>();
        return cloneHelper(node, visited);
    }
    private Node cloneHelper(Node node, Map<Node, Node>visited){
        if(visited.containsKey(node)) return visited.get(node);

        Node clonedNode = new Node(node.val);
        visited.put(node, clonedNode);

        for(Node neighbor : node.neighbors){
            clonedNode.neighbors.add(cloneHelper(neighbor,visited));

        }
        return clonedNode;
    }

        public static void main(String[] args) {

            Node node1 = new Node(1);
            Node node2 = new Node(2);
            Node node3 = new Node(3);
            Node node4 = new Node(4);

            node1.neighbors.add(node2);
            node1.neighbors.add(node4);
            node2.neighbors.add(node1);
            node2.neighbors.add(node3);
            node3.neighbors.add(node2);
            node3.neighbors.add(node4);
            node4.neighbors.add(node1);
            node4.neighbors.add(node3);


            CloneGraph solution = new CloneGraph();
            Node clonedNode = solution.clone(node1);

            System.out.println("Original graph:");
            printGraph(node1);

            System.out.println("\nCloned graph:");
            printGraph(clonedNode);
        }


        private static void printGraph(Node node) {
            if (node == null)
                return;

            System.out.print("Node " + node.val + " -> Neighbors: ");
            for (Node neighbor : node.neighbors) {
                System.out.print(neighbor.val + " ");
            }
            System.out.println();
            for (Node neighbor : node.neighbors) {
                printGraph(neighbor);
            }
        }


}
