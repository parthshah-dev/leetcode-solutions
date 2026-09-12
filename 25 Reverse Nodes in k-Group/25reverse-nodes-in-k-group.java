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
    public static int getSize(ListNode head){
        int size = 0;
        while(head != null){
            size++;
            head = head.next;
        }
        return size;
    }
    public static ListNode reverseList(ListNode head){
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prevTail = null;
        ListNode newHead = null;
        ListNode curr = head;

        int size = getSize(head);
        int n = size / k;
        while(n > 0){
            //reach to kth node
            ListNode temp = curr;
            int i=0;
            while(i < k-1){
                temp = temp.next;
                i++;
            }
        
            ListNode nextGroup = temp.next;
            temp.next = null;
            
            ListNode revHead = reverseList(curr);

            if(prevTail == null){
                newHead = revHead;
            }else{
                prevTail.next = revHead;
            }

            prevTail = curr;
            curr.next = nextGroup;
            curr = nextGroup;
        
            n--;
        }
        return newHead;
        
    }
}