package BINARYTREE;

public class TreeFromInOrderAndPreOrder {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }public static Node buildTree(int[]inOder,int[]preOrder,int start,int end,int idx){
        if(start>end){
            return null;
        }
        return helper(inOder, preOrder, start, end, 0);
    }public static Node helper(int[]inOder,int[]preOrder,int start,int end,int idx){
        if(start>end){
            return null;
        }int rootData=preOrder[idx];
        Node root=new Node(rootData);
        int i=start;
        for(;i<=end;i++){
            if(inOder[i]==rootData){
                break;
            }
        }idx++;
        root.left=helper(inOder, preOrder, start, i-1, idx);
        root.right=helper(inOder, preOrder, i+1, end, idx);
        return root;
    }public static void main(String[] args) {
        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };
        Node root=buildTree(inorder, preorder, 0, inorder.length-1, 0);
    }
}
