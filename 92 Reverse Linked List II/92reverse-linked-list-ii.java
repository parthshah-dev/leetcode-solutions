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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head.next == null || left == right){
            return head;
        }

        // Dummy node handles the case when left = 1
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        //Find node before left
        int i=1;
        ListNode leftLL = dummy; 
        while(i < left){
            leftLL = leftLL.next;
            i++;
        }

        // Original left node, which becomes the last node after reversal
        ListNode leftNode = leftLL.next;

        //Reverse the list from left to right
        int r=0;
        ListNode prev = null;
        ListNode curr = leftLL.next;
        while(r < right-left+1){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            r++;
        }

        //Reconnect
        leftLL.next = prev;
        leftNode.next = curr;

        return dummy.next;
    }
}