package BINARYTREE;

public class Symmetric {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }public static boolean isSysmmetric(Node root){
        if(root==null){
            return true;
        }return mirror(root.left, root.right);
    }public static boolean mirror(Node left,Node right){
        if(left==null && right==null){
            return true;
        }if(left==null || right==null){
            return false;
        }return (left.data==right.data) && mirror(left.left, right.right) && mirror(left.right, right.left);
    }
    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(2);
        node.left.left = new Node(3);
        node.left.right = new Node(4);
        node.right.left = new Node(4);
        node.right.right = new Node(3);
        System.out.println(isSysmmetric(node));
    }
}
