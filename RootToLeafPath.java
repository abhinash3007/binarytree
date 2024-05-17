package BINARYTREE;

import java.util.ArrayList;

public class RootToLeafPath {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }public static void path(Node root, int target) {
        if (root == null) {
            return;
        }
        ArrayList<Integer> pathList = new ArrayList<>();
        pathLeaf(root, target, pathList);
    }
    public static void pathLeaf(Node root,int target,ArrayList<Integer>list){
        if(root==null){
            return;
        }
        list.add(root.data);
        if (root.left==null && root.right==null && root.data==target) {
            for(int val:list){
                System.out.print(val+" ");
            }System.out.println();
            return;
        }pathLeaf(root.left, target,list);
        pathLeaf(root.right, target,list);
        list.remove(list.size()-1);
    }public static void main(String[] args) {
        Node node=new Node(1);
        node.left=new Node(2);
        node.right=new Node(3);
        node.left.left=new Node(4);
        node.left.right=new Node(5);
        node.right.right=new Node(6);
        node.left.left.left=new Node(7);
        path(node, 7);
    }
}
