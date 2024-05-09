package BINARYTREE;

import java.util.*;

public class ZigZagTraversal {
    public static class Node {
        int data;
        Node right;
        Node left;

        Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    public static void zigZag(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        Stack<Node> s = new Stack<>();
        boolean leftToRight = true;
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node curr = q.remove();
                if (leftToRight) {
                    System.out.println(curr.data);
                } else {
                    s.push(curr);
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }  
            }
            while (!s.isEmpty()) {
                System.out.println(s.peek().data);
                s.pop();
            }leftToRight=!leftToRight;
        }
    }
    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);
        zigZag(node);
    }
}
