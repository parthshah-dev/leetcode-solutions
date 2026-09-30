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
        HashMap<Node, Node> map = new HashMap<>();

        Node temp = head;
        while(temp != null){
            Node copyNode = new Node(temp.val);
            map.put(temp, copyNode);
            temp = temp.next;
        }

        temp = head;
        while(temp != null){
            Node copyNode = map.get(temp);
            copyNode.random = map.get(temp.random);
            copyNode.next = map.get(temp.next);

            temp = temp.next;
        }

        return map.get(head);
    }
}