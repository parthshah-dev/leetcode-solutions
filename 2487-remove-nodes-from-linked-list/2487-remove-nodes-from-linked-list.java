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
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
    public ListNode removeNodes(ListNode head) {
        ListNode ansList = new ListNode(-1);
        ListNode ansHead = ansList;

        Stack<Integer> st = new Stack<>();

        while(head!=null){
            st.push(head.val);
            head = head.next;
        }

        int currMax = st.pop();
        ansList.next = new ListNode(currMax);
        ansList = ansList.next;

        while(!st.isEmpty()){
            int num = st.pop();
            if(num >= currMax){
                currMax = num;
                ansList.next = new ListNode(currMax);
                ansList = ansList.next;
            }
        }

        ansHead = reverse(ansHead.next);

        return ansHead;
    }
}