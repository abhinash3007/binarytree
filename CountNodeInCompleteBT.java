package BINARYTREE;

import java.util.*;

public class CountNodeInCompleteBT {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }public static int heightLeft(Node root){
        if(root==null){
            return 0;
        }int left=heightLeft(root.left);
        return left+1;
    }public static int heightRight(Node root){
        if(root==null){
            return 0;
        }int right=heightRight(root.right);
        return right+1;
    }public static int countNodes(Node root){
        if(root==null){
            return 0;
        }int count=0;
        int left=heightLeft(root);
        int right=heightRight(root);
        if(left==right){
            return (int)Math.pow(2, left)-1;
        }else{
            return countNodes(root.left)+countNodes(root.right)+1;
        }
    }
    public static void main(String[] args) {
        Node node=new Node(1);
        node.left=new Node(2);
        node.right=new Node(3);
        node.left.left=new Node(4);
        node.left.right=new Node(5);
        node.right.right=new Node(6);
        node.left.left.left=new Node(7);
        System.out.println(countNodes(node));
    }
}
