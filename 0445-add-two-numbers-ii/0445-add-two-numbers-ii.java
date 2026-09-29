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
    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;

        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }

        l1 = reverse(l1);
        l2 = reverse(l2);

        int carry = 0;
        ListNode ansList = new ListNode(-1);
        ListNode ansHead = ansList;

        ListNode temp1 = l1;
        ListNode temp2 = l2;

        while(temp1!=null && temp2!=null){
            int sum = (temp1.val + temp2.val) + carry;
            ListNode newNode = new ListNode(sum % 10);
            carry = sum / 10;
            ansList.next = newNode;
            ansList = ansList.next;

            temp1=temp1.next;
            temp2=temp2.next;
        }

        while(temp1!=null){
            int sum = temp1.val + carry;
            ListNode newNode = new ListNode(sum % 10);
            carry = sum / 10;
            ansList.next = newNode;
            ansList = ansList.next;

            temp1=temp1.next;
        }

        while(temp2!=null){
            int sum = temp2.val + carry;
            ListNode newNode = new ListNode(sum % 10);
            carry = sum / 10;
            ansList.next = newNode;
            ansList = ansList.next;

            temp2=temp2.next;
        }

        if(carry!=0){
            ListNode newNode = new ListNode(carry);
            ansList.next=newNode;
        }

        ansHead = reverse(ansHead.next);

        return ansHead;
    }
}