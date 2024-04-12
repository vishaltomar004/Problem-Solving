package HomeWork.Tries_1;

public class CountPairsWithXORinaRange {
    
}

class Solution {
    class TrieNode {
        TrieNode left;
        TrieNode right;
        int count;
    }

    public void insertInTrie(TrieNode root, int val) {
        for (int i = MAX_BIT; i >= 0; i--) {
            int mask = 1 << i;
            int curr_bit = (val & mask) > 0 ? 1 : 0;
            if (curr_bit == 0) {
                if (root.left == null)
                    root.left = new TrieNode();
                root = root.left;
            } else {
                if (root.right == null)
                    root.right = new TrieNode();
                root = root.right;
            }
            root.count++;
        }
    }

    public int query(TrieNode root, int val, int high, int bitIndex) {
        if (root == null)
            return 0;
        if (bitIndex == -1)
            return root.count;

        int mask = 1 << bitIndex;
        int valBit = (val & mask) > 0 ? 1 : 0;
        int highBit = (high & mask) > 0 ? 1 : 0;

        if (valBit == 0) {
            if (highBit == 0)
                return query(root.left, val, high, bitIndex - 1);
            else
                return getCount(root.left) +
                        query(root.right, val, high, bitIndex - 1);
        } else {
            if (highBit == 0)
                return query(root.right, val, high, bitIndex - 1);
            else
                return getCount(root.right) +
                        query(root.left, val, high, bitIndex - 1);
        }
    }

    public int getCount(TrieNode root) {
        return (root == null) ? 0 : root.count;
    }
    
    final int MAX_BIT = 14;
    
    public int countPairs(int[] nums, int low, int high) {
        int count = 0;
        TrieNode root = new TrieNode();
        
        for (int i = 0; i < nums.length; i++) {
            count += query(root, nums[i], high, MAX_BIT);
            count -= query(root, nums[i], low - 1, MAX_BIT);

            insertInTrie(root, nums[i]);
        }
        return count;
    }
}
