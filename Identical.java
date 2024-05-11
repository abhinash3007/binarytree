package BINARYTREE;

public class Identical {
    public static class Node{
        int data;
        Node right;
        Node left;
        Node(int data){
            this.data=data;
            this.right=null;
            this.left=null;
        }
    }public static boolean isIdentical(Node root,Node root2){
        if(root==null && root2==null){
            return true;
        }if(root.data!=root2.data){
            return false;
        }isIdentical(root.left, root2.left);
        isIdentical(root.right, root2.right);
        return true;
    }public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.right = new Node(6);

        Node node2 = new Node(1);
        node2.left = new Node(2);
        node2.right = new Node(3);
        node2.left.left = new Node(4);
        node2.left.right = new Node(5);
        node2.right.right = new Node(6);
        System.out.println(isIdentical(node, node2));
    }
}
