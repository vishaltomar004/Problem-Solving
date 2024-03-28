package HomeWork.Tree_1_and_2;

public class FIndBottomLeftTreeValue {
    
}
class Pair{
    int level;
    TreeNode node;
    public Pair(int level , TreeNode node)
    {
        this.level=level;
        this.node=node;
    }
 }
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        if(root==null)
        return 0;
        int level=0;
        int data=root.val;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0 , root));

        while(!q.isEmpty())
        {
            Pair pair = q.poll();
            TreeNode curr=pair.node;
            int currlevel=pair.level;

            if(currlevel>level)
            {
                level=currlevel;
                data=curr.val;
            }

            if(curr.left!=null)
            {
                q.add(new Pair(level+1 , curr.left));
            }
            if(curr.right!=null)
            {
                q.add(new Pair(level+1 , curr.right));
            }
        }
        return data;
    }
}