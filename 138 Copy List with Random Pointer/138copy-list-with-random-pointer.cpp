/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/

class Solution {
public:
    Node* copyRandomList(Node* head) {
        //step 1: Make a new List with copy nodes
        Node* curr = head;
        while(curr){
            Node* copyNode = new Node(curr->val);
            copyNode->next = curr->next;
            curr->next = copyNode;
            curr = curr->next->next;
        }

        //step 2: Attach random pointer
        curr = head;
        while(curr){
            if(curr->random){
                curr->next->random = curr->random->next;
            }
            curr = curr->next->next;
        }

        //step 3: detach original list
        curr = head;
        Node* newHead = new Node(0);
        Node* ptr = newHead;
        while(curr){
            Node* copy = curr->next;
            curr->next = copy->next;
            ptr->next = copy;
            ptr = copy;
            curr = curr->next;
        }

        return newHead->next; 
    }
};