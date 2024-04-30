package BINARYTREE;

public class PreOrderTraversal {
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
        }
        preOrder(root.left);
        preOrder(root.right);
    }
    
    public static void main(String[] args) {
        Node node=new Node(1);
        node.left=new Node(2);
        node.right=new Node(3);
        node.left.left=new Node(4);
        node.left.right=new Node(5);
        node.right.right=new Node(6);
        preOrder(node);
    }
}
