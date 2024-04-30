package BINARYTREE;

public class PostOrderTraversal {
    public static class Node{
        int data;
        Node right;
        Node left;
        Node(int data){
            this.data=data;
            this.right=null;
            this.left=null;
        }
    }public static void postOrder(Node root){
        if(root==null){
            return;
        }postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data);
    }
   
    public static void main(String[] args) {
        Node node=new Node(1);
        node.left=new Node(2);
        node.right=new Node(3);
        node.left.left=new Node(4);
        node.left.right=new Node(5);
        node.right.right=new Node(6);
        postOrder(node);
    }
}
