package BINARYTREE;

import java.util.Stack;

public class IterativePostOrder {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }public static void iterativePost(Node root){
        if(root==null){
            return;
        }Stack<Node>s=new Stack<>();
        Stack<Node>s2=new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            Node current=s.pop();
            s2.push(current);
            if(current.left!=null){
                s.push(current.left);
            }if(current.right!=null){
                s.push(current.right);
            }
        }while (!s2.isEmpty()) {
            Node curr=s2.pop();
            System.out.println(curr.data);
        }
    }public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.right = new Node(6);
        iterativePost(node);
    }
}
