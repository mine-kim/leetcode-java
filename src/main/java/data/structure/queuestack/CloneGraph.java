package data.structure.queuestack;

import java.util.*;

/**
 * https://leetcode.com/explore/learn/card/queue-stack/232/practical-application-stack/1392/
 *
 * Example 1:
 *
 * Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
 * Output: [[2,4],[1,3],[2,4],[1,3]]
 * Explanation: There are 4 nodes in the graph.
 * 1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 * 2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 * 3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 * 4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 *
 * Example 2:
 *
 * Input: adjList = [[]]
 * Output: [[]]
 * Explanation: Note that the input contains one empty list. The graph consists of only one node with val = 1 and it does not have any neighbors.
 *
 * Example 3:
 *
 * Input: adjList = []
 * Output: []
 * Explanation: This an empty graph, it does not have any nodes.
 *
 * Constraints:
 *
 * The number of nodes in the graph is in the range [0, 100].
 * 1 <= Node.val <= 100
 * Node.val is unique for each node.
 * There are no repeated edges and no self-loops in the graph.
 * The Graph is connected and all nodes can be visited starting from the given node.
 */
public class CloneGraph {

    public HashMap<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        return clone(node);
    }

    public Node clone(Node node) {
        if (node == null) return null;

        if (map.containsKey(node.val))
            return map.get(node.val);

        Node newNode = new Node(node.val, new ArrayList<Node>());
        map.put(newNode.val, newNode);
        for (Node neighbor : node.neighbors)
            newNode.neighbors.add(clone(neighbor));
        return newNode;
    }


    static class Node {
         int val;
         List<Node> neighbors;
         Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
         Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
         Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static void main(String[] args) {
        CloneGraph solution = new CloneGraph();
        // Create a sample graph
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node1);
        node3.neighbors.add(node2);

        // Clone the graph
        Node clone = solution.cloneGraph(node1);

        // Verify the clone is a deep copy (optional)
        System.out.println("Original graph node1 neighbors:");
        for (Node neighbor : node1.neighbors) {
            System.out.print(neighbor.val + " ");
        }
        System.out.println();

        System.out.println("Cloned graph node1 neighbors:");
        for (Node neighbor : clone.neighbors) {
            System.out.print(neighbor.val + " ");
        }
        System.out.println();

        // Check if original and cloned nodes have different memory addresses
        if (node1 != clone && node1.neighbors.get(0) != clone.neighbors.get(0)) {
            System.out.println("Deep copy successful!");
        } else {
            System.out.println("Deep copy may not be successful.");
        }
    }
}
