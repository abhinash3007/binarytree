package BINARYTREE;

import java.util.*;

public class BoundaryTraversal {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void leftBoundary(Node root, Queue<Node> q) {
        if (root == null) {
            return;
        }
        q.add(root);
        Node curr = q.remove();
        while (curr != null && (curr.left != null || curr.right != null)) {
            System.out.println(curr.data);
            if (curr.left != null) {
                q.add(curr.left);
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    public static void leafNode(Node root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            System.out.println(root.data);
        }
        leafNode(root.left);
        leafNode(root.right);
    }

    public static void rightoundary(Node root, Stack<Node> s) {
        if (root == null) {
            return;
        }
        Node curr = root.right;
        while (curr != null && (curr.left != null || curr.right != null)) {
            s.push(curr.right);
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
    }

    public static void boundary(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        Stack<Node> s = new Stack<>();
        //System.out.println(root.data + " ");
        leftBoundary(root, q);
        leafNode(root);
        rightoundary(root, s);
        while (!s.isEmpty()) {
            System.out.print(s.pop().data + " ");
        }
    }

    public static void main(String[] args) {
        // Create the binary tree
        Node root = new Node(20);
        root.left = new Node(8);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right = new Node(22);
        root.right.right = new Node(25);

        // Perform Boundary Traversal and print the nodes
        System.out.println("Boundary Traversal:");
        boundary(root);
    }
}
