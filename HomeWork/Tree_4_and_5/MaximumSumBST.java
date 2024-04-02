package HomeWork.Tree_4_and_5;

import javax.swing.tree.TreeNode;

/**
 * MaximumSumBST
 */
public class MaximumSumBST {

     int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        check(root);
        return maxSum;
    }

    // Helper method to check if a subtree is a valid BST and calculate its sum
    // Returns an array where:
    //     [0] -> Whether the subtree is a valid BST
    //     [1] -> Sum of the subtree
    //     [2] -> Minimum value in the subtree
    //     [3] -> Maximum value in the subtree
    private int[] isValidBST(TreeNode node) {
        if (node == null) {
            return new int[]{1, 0, Integer.MAX_VALUE, Integer.MIN_VALUE};
        }

        int[] left = isValidBST(node.left);
        int[] right = isValidBST(node.right);

        if (left[0] == 1 && right[0] == 1 && node.val > left[3] && node.val < right[2]) {
            int sum = node.val + left[1] + right[1];
            maxSum = Math.max(maxSum, sum);
            int minVal = Math.min(node.val, left[2]);
            int maxVal = Math.max(node.val, right[3]);
            return new int[]{1, sum, minVal, maxVal};
        }

        return new int[]{0, 0, 0, 0}; // Indicates invalid BST
    }

    private void check(TreeNode root) {
        isValidBST(root); // Just call the method, no need to return anything
    }
}