/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;  
        ListNode prevGroupTail = dummy;
        while (true) {
            ListNode kthNode = getKthNode(prevGroupTail, k);
            if (kthNode == null) {
                break;
            }
            ListNode nextGroupHead = kthNode.next;
            ListNode prev = nextGroupHead;  
            ListNode curr = prevGroupTail.next;
            ListNode groupHead = curr; 
            for (int i = 0; i < k; i++) {
                ListNode nextTmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTmp;
            }
            prevGroupTail.next = kthNode;
            prevGroupTail = groupHead;
        }       
        return dummy.next;
    }
    private ListNode getKthNode(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}