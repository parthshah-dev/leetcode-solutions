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
    public static ListNode reverseList(ListNode head){
        ListNode prev=null;
        ListNode curr = head;
        
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public int pairSum(ListNode head) {
        //if list has only 2 nodes
        if(head.next.next == null){
            return head.val + head.next.val;
        }

        int maxTwinSum = Integer.MIN_VALUE;

        ListNode slow = head;
        ListNode fast = head.next;

        //find mid
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode head2 = slow.next;
        slow.next = null;

        //Reverse the 2nd list
        head2 = reverseList(head2);

        //calculate max sum
        while(head!=null && head2!=null){
            int sum = head.val + head2.val;
            maxTwinSum = Math.max(maxTwinSum, sum);
            head = head.next;
            head2 = head2.next;
        }

        return maxTwinSum;
    }
}