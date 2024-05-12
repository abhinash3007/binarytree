package BINARYTREE;

import java.util.*;

public class BottomView {
    public static class Node{
        int data;
        Node right;
        Node left;
        Node(int data){
            this.data=data;
            this.right=null;
            this.left=null;
        }
    }public static void bottom(Node root){
        if(root==null){
            return;
        }Map<Integer,Integer>map=new TreeMap<>();
        Queue<Node>q=new LinkedList<>();
        Queue<Integer>dis=new LinkedList<>();
        q.add(root);
        dis.add(0);
        while (!q.isEmpty()) {
            Node curr=q.remove();
            int dist=dis.remove();
            map.put(dist, curr.data);
            if(curr.left!=null){
                q.add(curr.left);
                dis.add(dist-1);
            }if(curr.right!=null){
                q.add(curr.right);
                dis.add(dist+1);
            }
        }for(int val:map.values()){
            System.out.println(val+" ");
        }        
    }public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=root.left.right;
        root.right.left.left=new Node(7);
        root.right.left.right=new Node(8);
        bottom(root);
    }
}
