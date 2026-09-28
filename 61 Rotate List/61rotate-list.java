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
    public ListNode rotateRight(ListNode head, int k) {
        int size = getSize(head);

        if(size == 0 || k == 0){
            return head;
        }

        k = k % size;

        if(k == 0){
            return head;
        }

        //make the list circular
        ListNode curr = head;
        while(curr.next!=null){
            curr = curr.next;
        }
        curr.next=head;

        int i=1;
        ListNode temp = head;
        while(i < size-k){
            temp = temp.next;
            i++;
        }
        ListNode newHead = temp.next;
        temp.next = null;

        return newHead;
    }
}