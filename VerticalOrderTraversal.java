package BINARYTREE;

import java.util.*;

import javax.swing.tree.TreeNode;

public class VerticalOrderTraversal {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }public static void vertical(Node root){
        if(root==null){
            return;
        }Map<Integer,List<Integer>>map=new TreeMap<>();
        Queue<Node>q=new LinkedList<>();
        Queue<Integer>dist=new LinkedList<>();
        q.add(root);
        dist.add(0);
        while (!q.isEmpty()) {
            Node curr=q.remove();
            int dis=dist.remove();
            if(!map.containsKey(dis)){
                map.put(dis, new ArrayList<>());
            }map.get(dis).add(curr.data);
            if(curr.left!=null){
                q.add(curr.left);
                dist.add(dis-1);
            }if(curr.right!=null){
                q.add(curr.right);
                dist.add(dis+1);
            }// Print nodes in vertical order
        }
        for (List<Integer> list : map.values()) {
            for (int val : list) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Create the binary tree
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.right = new Node(6);
        vertical(node);
    }
}
