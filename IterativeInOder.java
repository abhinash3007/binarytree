package BINARYTREE;

import java.util.Stack;

public class IterativeInOder {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }public static void iterativeIn(Node root){
        if(root==null){
            return;
        }Stack<Node>s=new Stack<>();
        Node current=root;
        while (current!=null || !s.isEmpty()) {
            while (current!=null) {
                s.push(current);
                current=current.left;
            }current=s.pop();
            System.out.println(current.data);
            current=current.right;
        }
    }public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        
        node.right.right = new Node(6);
        iterativeIn(node);
    }
}
