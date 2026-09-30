/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        //interleaving method approach - optimal space
        if(head == null){
            return head;
        }

        Node temp = head;
        while(temp!=null){
            Node tempNext = temp.next;
            Node copyNode = new Node(temp.val);
            temp.next = copyNode;
            copyNode.next = tempNext;
            temp = tempNext;
        }

        //setting random pointers
        temp = head;
        while(temp != null){
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        Node copyHead = head.next;
        temp = head;

        while (temp != null) {
            Node copy = temp.next;

            temp.next = copy.next;

            if (copy.next != null) {
                copy.next = copy.next.next;
            }

            temp = temp.next;
        }

        return copyHead;
    }
}