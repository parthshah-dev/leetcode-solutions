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
    public ListNode removeNodes(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();

        while(head!=null){
            arr.add(head.val);
            head = head.next;
        }

        Stack<Integer> st = new Stack<>();
        int[] nextGreater = new int[arr.size()];
        for(int i=0; i<arr.size(); i++){
            while(!st.isEmpty() && arr.get(i) > arr.get(st.peek())){
                nextGreater[st.pop()] = arr.get(i);
            }
            st.push(i);
        }

        //element who does not next greater will be 0
        //create ans list

        ListNode ansList = new ListNode(-1);
        ListNode ansHead = ansList;

        for(int i=0; i<nextGreater.length; i++){
            if(nextGreater[i] == 0){
                ListNode newNode = new ListNode(arr.get(i));
                ansList.next = newNode;
                ansList = ansList.next;
            }
        }

        return ansHead.next;

    }
}