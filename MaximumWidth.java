package BINARYTREE;

import java.util.*;


public class MaximumWidth {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node (int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }public static void max(Node root){
        if(root==null){
            return;
        }Queue<Node>q=new LinkedList<>();
        Queue<Integer>q2=new LinkedList<>();
        q.add(root);
        q2.add(0);
        int max=0;
        while (!q.isEmpty()) {
            int size=q.size();
            int first=q2.peek();
            int last=first;
            for(int i=0;i<size;i++){
                Node curr=q.remove();
                int idx=q2.remove();
                last=idx;
                if(curr.left!=null){
                    q.add(curr.left);
                    q2.add(2*idx+1);
                }if(curr.right!=null){
                    q.add(curr.right);
                    q2.add(2*idx+2);
                }
            }max=Math.max(max,last-first+1);
        }System.out.println(max);
    }public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.right = new Node(6);
        max(node);
    }
}
