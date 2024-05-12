package BINARYTREE;

public class ChildrenSumProperty {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }public static boolean sum(Node root){
        if(root==null || (root.left==null && root.right==null)){
            return true;
        }int sum=0;
        if(root.left!=null){
            sum+=root.left.data;
        }if(root.right!=null){
            sum+=root.right.data;
        }return (root.data==sum) && sum(root.left) && sum(root.right);
    }public static void main(String[] args) {
        Node node = new Node(2);
        node.left = new Node(35);
        node.right = new Node(10);
        node.left.left = new Node(2);
        node.left.right = new Node(3);
        node.right.left = new Node(5);
        node.right.right = new Node(2);
        System.out.println(sum(node));
    }
}
