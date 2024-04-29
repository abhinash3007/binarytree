package BINARYTREE;

import BASICMATHS.n1;

public class implementation {
    public static class Node{
        int data;
        Node right;
        Node left;
        Node(int data){
            this.data=data;
            this.right=null;
            this.left=null;
        }
    }public static void preOrder(Node root){
        if(root!=null){
            System.out.print(root.data);
        preOrder(root.left);
        preOrder(root.right);
        }
    }public static void postOrder(Node root){
        if(root==null){
            return;
        }postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data);
    }
    public static void inOrder(Node root){
        if(root==null){
            return;
        }inOrder(root.left);
        System.out.print(root.data);
        inOrder(root.right);
    }
    public static void main(String[] args) {
        Node node=new Node(1);
        node.left=new Node(2);
        node.right=new Node(3);
        node.left.left=new Node(4);
        node.left.right=new Node(5);
        node.right.right=new Node(6);
        //preOrder(node);
        //inOrder(node);
        postOrder(node);
    }
}
