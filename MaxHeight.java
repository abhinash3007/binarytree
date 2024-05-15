package BINARYTREE;

public class MaxHeight {
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
    }public static void main(String[] args) {
        Node node=new Node(1);
        node.left=new Node(2);
        node.right=new Node(3);
        node.left.left=new Node(4);
        node.left.right=new Node(5);
        node.right.right=new Node(6);
        System.out.println(height(node));
    }
}
