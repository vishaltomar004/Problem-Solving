package HomeWork.Tree_6;

public class BinaryTreeToCDLL {
    
}
class Solution{
    Node prev=null;
    Node bTreeTolist(Node root){
        if(root==null){
            return root;
        }
        Node head=bTreeTolist(root.left);
        if(prev==null){
            head=root;
        }
        else{
            root.left=prev;
            prev.right=root;
        }
        prev=root;
        bTreeTolist(root.right);
        return head;
    }
    Node bTreeToClist(Node root){
        if(root==null){
            return null;
        }
        if(root.right==null && root.left==null){
            root.right=root;
            root.left=root;
            return root;
        }
        Node head=bTreeTolist(root);
        Node curr=head;
        while(curr.right!=null){
            curr=curr.right;
        }
        curr.right=head;
        head.left=curr;
        return head;
    }
    
}

