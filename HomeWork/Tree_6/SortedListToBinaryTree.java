package HomeWork.Tree_6;

import javax.swing.tree.TreeNode;

public class SortedListToBinaryTree {
     public TreeNode sortedListToBST(ListNode head) {
        if(head == null)    return null;

        ListNode midNode = findMidNode(head);

        TreeNode root = new TreeNode(midNode.val);
        if(head == midNode) return root;

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(midNode.next);

        return root;
    }
    private ListNode findMidNode(ListNode head){
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if(prev!=null){
            prev.next = null;
        }
        return slow;
    }
}
