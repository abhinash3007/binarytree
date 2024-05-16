package BINARYTREE;

import java.util.*;

public class NodeAtDistanceK {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void distanceK(Node root, Node target, int k) {
        List<Integer> result = new ArrayList<>();
        if (root == null || target == null)
            return;

        Map<Node, Node> parentMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();

        buildParentMap(root, null, parentMap);

        queue.offer(target);
        visited.add(target);

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (level == k) {
                for (int i = 0; i < size; i++) {
                    System.out.println(queue.peek().data);
                    queue.remove();
                }
                return;
            }
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                if (curr.left != null && !visited.contains(curr.left)) {
                    queue.offer(curr.left);
                    visited.add(curr.left);
                }

                if (curr.right != null && !visited.contains(curr.right)) {
                    queue.offer(curr.right);
                    visited.add(curr.right);
                }

                // Add parent of current node
                Node parent = parentMap.get(curr);
                if (parent != null && !visited.contains(parentMap.get(curr))) {
                    queue.offer(parent);
                    visited.add(parent);
                }
            }
            level++;
        }
    }

    private static void buildParentMap(Node node, Node parent, Map<Node, Node> parentMap) {
        if (node == null)
            return;
        parentMap.put(node, parent);
        buildParentMap(node.left, node, parentMap);
        buildParentMap(node.right, node, parentMap);
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);
        root.right.left = new Node(0);
        root.right.right = new Node(8);

        Node target = root.left;
        int k = 2;
        distanceK(root, target, k);
        //List<Integer> result = solution.distanceK(root, target, k);
    }
}
