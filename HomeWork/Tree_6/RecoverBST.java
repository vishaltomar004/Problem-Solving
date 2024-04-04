package HomeWork.Tree_6;

import javax.swing.tree.TreeNode;

public class RecoverBST {
     TreeNode prev=new TreeNode(Integer.MIN_VALUE);
    TreeNode curr=null;
    TreeNode next=null;
    TreeNode finale=null;
    public void recoverTree(TreeNode root) {
          
          if(root==null) return;
          in(root);
          if(curr!=null && finale !=null)
          {
            int temp=curr.val;
            curr.val=finale.val;
            finale.val=temp;
          }
          else if(curr!=null && next!=null) {
            int temp=curr.val;
            curr.val=next.val;
            next.val=temp;
          }

    }
   public void in(TreeNode r)
   {
    if(r==null) return ;
        in(r.left);
    
    if(prev!=null && r.val<prev.val)
    {
           if(curr==null)
           {
            curr=prev;
            next=r;
           }
           else {
            finale =r;
           }
    }
    
    prev=r;
    in(r.right);

       }

}
