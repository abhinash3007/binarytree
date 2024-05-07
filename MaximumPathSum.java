package BINARYTREE;

public class MaximumPathSum {
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
        return Math.max(left, right)+root.data;
    }public static int maxSum(Node root){
        if(root==null){
            return 0;
        }int sum=root.data+height(root.left)+height(root.right);
        return Math.max(sum, Math.max(maxSum(root.left), maxSum(root.right)));
    }public static int optimal(Node root){
        if(root==null){
            return 0;
        }int max=0;
        int left=Math.max(0,optimal(root.left));
        int right=Math.max(0,optimal(root.right));
        max=Math.max(max, right+left+root.data);
        return root.data+Math.max(left, right);
    }public static int optimal2(Node root){
        int max=Integer.MIN_VALUE;
        optimal(root);
        return max;
    }
    public static void main(String[] args) {
        Node node=new Node(1);
        node.left=new Node(2);
        node.right=new Node(3);
        node.left.left=new Node(4);
        node.left.right=new Node(5);
        node.right.right=new Node(6);
        node.left.left.left=new Node(7);
        System.out.println(maxSum(node));
        System.out.println(optimal2(node));
    }
}
