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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode mergedHead = new ListNode(-1);
        ListNode mergedTemp = mergedHead;

        ListNode temp1 = list1;
        ListNode temp2 = list2;

        while (temp1 != null && temp2 != null) {

            if (temp1.val < temp2.val) {
                mergedTemp.next = temp1;
                temp1 = temp1.next;
            } else {
                mergedTemp.next = temp2;
                temp2 = temp2.next;
            }

            mergedTemp = mergedTemp.next;
        }

        while (temp1 != null) {
            mergedTemp.next = temp1;
            temp1 = temp1.next;
            mergedTemp = mergedTemp.next;
        }

        while (temp2 != null) {
            mergedTemp.next = temp2;
            temp2 = temp2.next;
            mergedTemp = mergedTemp.next;
        }

        return mergedHead.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;

        ListNode result = lists[0];

        for(int i=1; i<lists.length; i++){
            result = mergeTwoLists(result, lists[i]);
        }

        return result;
    }
}