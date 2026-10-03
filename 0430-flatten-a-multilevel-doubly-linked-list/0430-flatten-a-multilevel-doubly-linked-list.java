/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node curr = head;

        if(curr == null){
            return head;
        }

        while(curr != null){
            if(curr.child!=null){
                Node currNext = curr.next;
                curr.next = flatten(curr.child);
                curr.child.prev = curr;
                curr.child = null;

                while(curr.next != null){
                    curr = curr.next;
                }

                if(currNext != null){
                    curr.next = currNext;
                    currNext.prev = curr;
                }
            }

            curr = curr.next;
        }

        return head;
    }   
}