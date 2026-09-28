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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode ansList = new ListNode(-1);
        ListNode ansHead = ansList;

        //store frequencies in hashmap
        ListNode temp = head;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(temp != null){
            map.put(temp.val, map.getOrDefault(temp.val, 0)+1);
            temp = temp.next;
        }

        //create unique list
        while(head != null){
            if(map.get(head.val) == 1){
                ansList.next = head;
                ansList = ansList.next;
            }
            head = head.next;
        }
        ansList.next = null;
        return ansHead.next;
    }
}