class MyLinkedList {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public int getSize(Node head){
        int size = 0;
        Node temp = head;

        while(temp != null){
            size++;
            temp = temp.next;
        }
        return size;
    }

    static Node head;

    public MyLinkedList() {
        head = null;
    }
    
    public int get(int index) {
        if(index >= getSize(head)){
            return -1;
        }
        Node temp = head;
        while(index > 0){
            temp = temp.next;
            index--;
        }
        return temp.data;
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val);

        newNode.next = head;
        head = newNode;
    }
    
    public void addAtTail(int val) {
        Node newNode = new Node(val);

        if(head == null){
            head = newNode;
            return;
        }

        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
    }
    
    public void addAtIndex(int index, int val) {
        Node newNode = new Node(val);

        int size = getSize(head);
        if(index < 0 || index > size){
            return;
        }

        if(index == 0){
            addAtHead(val);
            return;
        }

        if(index == size){
            addAtTail(val);
            return;
        }

        Node temp = head;

        while(index > 1){
            temp = temp.next;
            index--;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }
    
    public void deleteAtIndex(int index) {
        int size = getSize(head);
        if(index < 0 || index >= size){
            return;
        }

        if(index == 0){
            head = head.next;
            return;
        }    

        Node temp = head;
        while(index > 1){
            temp = temp.next;
            index--;
        }

        temp.next = temp.next.next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */