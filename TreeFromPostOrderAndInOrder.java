package BINARYTREE;

public class TreeFromPostOrderAndInOrder {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }public static Node buildTree(int[]inOder,int[]postOrder,int start,int end,int idx){
        if(start>end){
            return null;
        }
        return helper(inOder, postOrder, start, end, idx);
    }public static Node helper(int[]inOder,int[]postOrder,int start,int end,int idx){
        if(start>end){
            return null;
        }int rootData=postOrder[idx];
        Node root=new Node(rootData);
        int i=start;
        for(;i<=end;i++){
            if(inOder[i]==rootData){
                break;
            }
        }idx--;
        root.right=helper(inOder, postOrder, start, i-1, idx);
        root.left=helper(inOder, postOrder, i+1, end, idx);
        return root;
    }public static void main(String[] args) {
        int[] postOrder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };
        Node root=buildTree(inorder, postOrder, 0, inorder.length-1, postOrder.length-1);
    }
}
