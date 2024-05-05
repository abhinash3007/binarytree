package BINARYTREE;

import BASICMATHS.n1;

public class DiameterOfBinaryTree {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }public static int height(Node root){
        if(root==null){
            return 0;
        }int left=height(root.left);
        int right=height(root.right);
        int max=Math.max(left, right)+1;
        return max;
    }public static int diameter(Node root){
        if(root==null){
            return 0;
        }int curr=0;
        int left=height(root.left);
        int right=height(root.right);
        curr=left+right+1;
        int l=diameter(root.right);
        int r=diameter(root.right);
        return Math.max(Math.max(l, r),curr);
    }
    public static int optimalDiameter(Node root) {
        if (root == null) {
            return 0;
        }
        int maxDiameter = 0;
        //maxDiameter = Math.max(maxDiameter, diameter(root.left) + diameter(root.right) + 1);
        int leftDiameter = optimalDiameter(root.left);
        int rightDiameter = optimalDiameter(root.right);
        maxDiameter=Math.min(leftDiameter+rightDiameter,maxDiameter);
        return Math.max(leftDiameter, rightDiameter)+1;
    }
    public static void main(String[] args) {
        Node node=new Node(1);
        node.left=new Node(2);
        node.right=new Node(3);
        node.left.left=new Node(4);
        node.left.right=new Node(5);
        node.right.right=new Node(6);
        node.left.left.left=new Node(7);
        System.out.println(diameter(node));
        System.out.println(optimalDiameter(node));
    }
}
