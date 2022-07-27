package practice;

import java.util.HashMap;

public class LeetCode146_LRU_Cache {
    private int size;
    private int capacity;
    private HashMap<Integer, Node> cacheMap;
    private Node head;
    private Node tail;
    private class Node {
        int key;
        int val;
        Node next;
        Node prev;
        Node() {}
        Node(int key, int val) {this.key = key; this.val = val;}
    }

    private void initList() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    private void addNode(Node node) {
        node.next = tail;
        node.prev = tail.prev;
        node.prev.next = node;
        tail.prev = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToTail(Node node) {
        removeNode(node);
        addNode(node);
    }

    public LeetCode146_LRU_Cache(int capacity) {
        initList();
        this.size = 0;
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
    }

    public int get(int key) {
        Node cur = cacheMap.getOrDefault(key, null);
        if (cur == null) {
            return -1;
        }
        moveToTail(cur);
        return cur.val;
    }

    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            Node cur = cacheMap.get(key);
            cur.val = value;
            moveToTail(cur);
        }
        else {
            if (size == capacity) {
                cacheMap.remove(head.next.key);
                removeNode(head.next);
                size--;
            }
            Node cur = new Node(key, value);
            addNode(cur);
            cacheMap.put(key, cur);
            size++;
        }
        System.out.println(cacheMap.toString());
    }
}
