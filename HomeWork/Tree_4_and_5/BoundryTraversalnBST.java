package HomeWork.Tree_4_and_5;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class BoundryTraversalnBST {
     public static List<Integer> traverseBoundary(TreeNode root){
        ArrayList<Integer> result = new ArrayList<>();
        
        if (root != null) {
            result.add(root.data);
            traverseLeftBoundary(root.left, result);
            traverseLeaves(root.left, result);
            traverseLeaves(root.right, result);
            traverseRightBoundary(root.right, result);
        }
        
        return result;
    }
    // left aboundry traversal excluding leaf
    static void traverseLeftBoundary(TreeNode root, List<Integer> result) {
        if (root == null || (root.left == null && root.right == null)) return;
        
        result.add(root.data);
        
        if (root.left != null)
            traverseLeftBoundary(root.left, result);
        else
            traverseLeftBoundary(root.right, result);
    }
        // right aboundry traversal excluding leaf
    static void traverseRightBoundary(TreeNode root, List<Integer> result) {
        if (root == null || (root.left == null && root.right == null)) return;
        
        if (root.right != null)
            traverseRightBoundary(root.right, result);
        else
            traverseRightBoundary(root.left, result);
        
        result.add(root.data); // Add after child call to ensure bottom-up order
    }
    //leaf traversal
    static void traverseLeaves(TreeNode root, List<Integer> result) {
        if (root == null) return;
        
        traverseLeaves(root.left, result);
        
        if (root.left == null && root.right == null)
            result.add(root.data);
        
        traverseLeaves(root.right, result);
    }
}
