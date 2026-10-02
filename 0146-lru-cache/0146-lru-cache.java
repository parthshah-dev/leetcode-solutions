class LRUCache {

    static class Node{
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    int size;
    int capacity;
    HashMap<Integer, Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = null;
        this.tail = null; 
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        Node node = map.get(key);

        remove(node);
        addToTail(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        //node already exists
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            remove(node);
            addToTail(node);
            return;
        }

        if(size == capacity){
            Node oldHead = head;
            remove(oldHead);
            map.remove(oldHead.key);
            size--;
        }

        Node newNode = new Node(key, value);

        //if first node
        if(head == null){
            head = tail = newNode;
        }else{
            addToTail(newNode);
        }

        map.put(key, newNode);
        size++;
    }

    public void addToTail(Node node){
        if (tail == null) {
            head = tail = node;
            return;
        }
        tail.next = node;
        node.prev = tail;
        tail = node;
    }

    public void remove(Node node){
        if(node == head){
            head = head.next;
        }

        if(node == tail){
            tail = tail.prev;
        }

        if(node.prev != null){
            node.prev.next = node.next;
        }

        if(node.next != null){
            node.next.prev = node.prev;
        }

        node.prev = null;
        node.next = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */