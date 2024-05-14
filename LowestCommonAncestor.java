package BINARYTREE;
import java.util.*;
public class LowestCommonAncestor {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }public static boolean lca1(Node root,int x,ArrayList<Integer>list){
        if(root==null){
            return true;
        }list.add(root.data);
        if(root.data==x){
            return true;
        }if (lca1(root.left, x, list) || lca1(root.right, x, list)) {
            return true;
        }list.remove(list.size()-1);
        return false;
        
    }public static void lca3(Node root,int p,int q){
        if(root==null){
            return;
        }ArrayList<Integer>list1=new ArrayList<>();
        ArrayList<Integer>list2=new ArrayList<>();
        if(!lca1(root, q, list1) || (!lca1(root, p, list2))){
            return;
        }int i=0;
        while (i<list1.size() && i<list2.size()) {
            if(!list1.get(i).equals(list2.get(i))){
                break;
            }i++;
        }System.out.println(i-1);
    }public static Node optimal(Node root,int p,int q){
        if(root==null){
            return null;
        }if (root.data==p || root.data==q) {
            return root;
        }Node left=optimal(root.left, p, q);
        Node right=optimal(root.right, p, q);
        if (left==null) {
            return right;
        }if (right==null) {
            return left;
        }return root;
    }
    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.right = new Node(6);
        lca3(node, 6, 2);
        Node l=optimal(node, 1, 2);
        System.out.println(l.data);
    }
}
