package BINARYTREE;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.TreeMap;
import javax.management.Query;

import basicHASHING.characterHashing;

public class TopView {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }public static void top(Node root){
        if(root==null){
            return;
        }Queue<Node>q=new LinkedList<>();
        Stack<Node>s=new Stack<>();
        q.add(root);
        Node curr=root;
        while (curr.left!=null) {
            s.push(curr.left);
            curr=curr.left;
        }
        while(!s.isEmpty()){
        System.out.println(s.peek().data);
        s.pop();
    }System.out.println(root.data);
    curr=root.right;
        while (curr != null) {
            System.out.println(curr.data + " ");
            curr = curr.right;
        }
    }public static void top2(Node root){
        if(root==null){
            return;
        } TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Node>q=new LinkedList<>();
        Queue<Integer>dis=new LinkedList<>();
        q.add(root);
        dis.add(0);
        while (!q.isEmpty()) {
            Node curr=q.remove();
            int dist=dis.remove();
            if(!map.containsKey(dist)){
                map.put(dist,curr.data);
            }if (curr.left!=null) {
                q.add(curr.left);
                dis.add(dist-1);
            }if (curr.right!=null) {
                q.add(curr.right);
                dis.add(dist+1);
            }
        }for (int val : map.values()) {
            System.out.print(val + " ");
        }
    }
    public static void main(String[] args) {
        Node node=new Node(1);
        node.left=new Node(2);
        node.right=new Node(3);
        node.left.left=new Node(4);
        node.left.right=new Node(5);
        node.right.right=new Node(6);
        node.left.left.left=new Node(7);
        node.right.right.right=new Node(10);
        //top(node);
        top2(node);
    }
}
