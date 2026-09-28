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
    public ListNode partition(ListNode head, int x) {
        ListNode lesser = new ListNode(-1);
        ListNode greater = new ListNode(-1);
        ListNode lessHead = lesser;
        ListNode greaterHead = greater;

        ListNode temp = head;

        while(temp!=null){
            if(temp.val < x){
                lesser.next = temp;
                lesser = lesser.next;
            }else{
                greater.next = temp;
                greater = greater.next;
            }
            temp = temp.next;
        }

        greater.next = null;
        lesser.next = greaterHead.next;
        
        return lessHead.next;
    }
}