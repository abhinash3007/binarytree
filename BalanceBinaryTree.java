package BINARYTREE;

public class BalanceBinaryTree {
    public static class Node{
        int data;
        Node right;
        Node left;
        Node(int data){
            this.data=data;
            this.right=null;
            this.left=null;
        }
    }public static int height(Node root){
        if(root==null){
            return 0;
        }int left=height(root.left);
        int right=height(root.right);
        int max=Math.max(left, right)+1;
        return max;
    }public static boolean balance(Node root){
        if(root==null){
            return true;
        }int left=height(root.left);
        int right=height(root.right);
        if(Math.abs(right-left)>1 && balance(root.left) && balance(root.right)){
            return false;
        }return true;
    }public static boolean optimal(Node root){
        return getHeight(root)!=-1;
    }
    private static int getHeight(Node root) {
        if(root==null){
            return 0;
        }int left=getHeight(root.left);
        if(left==-1){
            return-1;
        }
        int right=getHeight(root.right);
        if(right==-1){
            return -1;
        }if (Math.abs(left-right)>1) {
            return -1;
        }return Math.max(left, right) + 1;
    }
    public static void main(String[] args) {
        Node node=new Node(1);
        node.left=new Node(2);
        node.right=new Node(3);
        node.left.left=new Node(4);
        node.left.right=new Node(5);
        node.right.right=new Node(6);
        node.left.left.left=new Node(7);
        node.left.left.right=new Node(8);
        node.left.left.left.left=new Node(7);
        node.left.left.left.left.left=new Node(7);
        node.left.left.left.left.left.left=new Node(7);
        System.out.println(balance(node));
    }
}
