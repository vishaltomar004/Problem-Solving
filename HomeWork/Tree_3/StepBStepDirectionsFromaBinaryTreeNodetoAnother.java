package HomeWork.Tree_3;

import javax.swing.tree.TreeNode;

public class StepBStepDirectionsFromaBinaryTreeNodetoAnother {
     public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder start = new StringBuilder();
        StringBuilder des = new StringBuilder();

        find(root,startValue,start);
        find(root,destValue,des);

        start.reverse();
        des.reverse();

        while(start.length()>0 && des.length()>0 && start.charAt(0) == des.charAt(0))
        {
            start.deleteCharAt(0);
            des.deleteCharAt(0);
        }
        return "U".repeat(start.length()) + des.toString();
    }
    private boolean find(TreeNode root, int val, StringBuilder sb)
    {
        if(root.val == val)
        return true;
        if(root.left != null && find(root.left,val,sb))
        {
            sb.append("L");
            return true;
        }
        if(root.right != null && find(root.right,val,sb))
        {
            sb.append("R");
            return true;
        }
        return false;
    }
}
