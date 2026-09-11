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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode newHead = head.next;
        ListNode prevTail = null;

        while(head!=null && head.next!=null){
            ListNode first = head;
            ListNode second = head.next;
            ListNode remList = second.next;
            
            second.next = first;
            first.next = remList;

            if(prevTail != null){
                prevTail.next = second;
            }

            prevTail = first;

            head = remList;
        }

        return newHead;
    }
}