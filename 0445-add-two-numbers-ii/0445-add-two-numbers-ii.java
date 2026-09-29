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
            prev = curr;
            curr = next;
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

        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        while(l1!=null){
            st1.push(l1.val);
            l1=l1.next;
        }

        while(l2!=null){
            st2.push(l2.val);
            l2=l2.next;
        }

        int carry = 0;
        ListNode ansList = new ListNode(-1);
        ListNode ansHead = ansList;

        while(!st1.isEmpty() && !st2.isEmpty()){
            int sum = (st1.pop() + st2.pop()) + carry;
            ListNode newNode = new ListNode(sum % 10);
            carry = sum / 10;
            ansList.next = newNode;
            ansList = ansList.next;
        }

        while(!st1.isEmpty()){
            int sum = st1.pop() + carry;
            ListNode newNode = new ListNode(sum % 10);
            carry = sum / 10;
            ansList.next = newNode;
            ansList = ansList.next;
        }

        while(!st2.isEmpty()){
            int sum = st2.pop() + carry;
            ListNode newNode = new ListNode(sum % 10);
            carry = sum / 10;
            ansList.next = newNode;
            ansList = ansList.next;
        }

        if(carry!=0){
            ListNode newNode = new ListNode(carry);
            ansList.next=newNode;
        }

        ansHead = reverse(ansHead.next);
        return ansHead;
    }
}