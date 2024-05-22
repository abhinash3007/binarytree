package BINARYTREE;
import java.util.*;
public class SerializeAndDeserialize {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }public static void serializeHelper(Node root,StringBuilder sb){
        if (root==null) {
            sb.append("null,");
            return;
        }sb.append(root.data+",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }public static String serialize(Node root){
        StringBuilder sb=new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }public static Node deserialize(String data){
        String[]node=data.split(",");
        Queue<String>q=new LinkedList<>();
        for(String nodes :node){
            q.add(nodes);
        }return desrializeHelper(q);
    }public static Node desrializeHelper(Queue<String>q){
        String val=q.remove();
        if(val.equals("null")){
            return null;
        }Node node=new Node(Integer.parseInt(val));
        node.left=desrializeHelper(q);
        node.right=desrializeHelper(q);
        return node;
    }
    //public static Node deserialize(String data) {
    //     if (data == null || data.isEmpty()) {
    //         return null;
    //     }

    //     String[] values = data.split(",");
    //     Node root = new Node(Integer.parseInt(values[0]));
    //     Queue<Node> queue = new LinkedList<>();
    //     queue.offer(root);

    //     int i = 1;
    //     while (!queue.isEmpty()) {
    //         Node node = queue.poll();
    //         if (!values[i].equals("null")) {
    //             node.left = new Node(Integer.parseInt(values[i]));
    //             queue.offer(node.left);
    //         }
    //         i++;
    //         if (!values[i].equals("null")) {
    //             node.right = new Node(Integer.parseInt(values[i]));
    //             queue.offer(node.right);
    //         }
    //         i++;
    //     }return root;
    // }
    public static void printTree(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.data + " ");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }
    public static void main(String[] args) {
        Node root=new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        String data=serialize(root);
        System.out.println(data);
        Node node=deserialize(data);
        System.out.println(node.data);
        printTree(node);
    }
}
