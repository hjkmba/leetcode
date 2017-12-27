package tag.undefined;

import java.util.*;

/**
 * Created by he.dong on 12/26/2017.
 */
public class _146_LRUCache {
    private int capacity;
    private HashMap<Integer, DLinkNode> map;
    private DLinkNode head;

    class DLinkNode{
        int key;
        int value;
        DLinkNode prev;
        DLinkNode next;
        public DLinkNode(){}
        public DLinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "[" + key + "," + value + ']';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DLinkNode dLinkNode = (DLinkNode) o;
            return key == dLinkNode.key &&
                    value == dLinkNode.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }

    public _146_LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new DLinkNode();
        head.next = head;
        head.prev = head;

    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int val = map.get(key).value;
            removeNode(key);
            addNodeToHead(key, val);
            return val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (isFull() && !map.containsKey(key)) {
            invalidLRU();
        }
        if (!isFull() || map.containsKey(key)) {
            if (map.containsKey(key))
                removeNode(key);
            addNodeToHead(key, value);
        }
        printChain();
    }

    private void removeNode(int key) {
        DLinkNode node = map.get(key);

        node.next.prev = node.prev;
        node.prev.next = node.next;

        map.remove(node.key);
    }

    private void addNodeToHead(int key, int value) {
        DLinkNode node = new DLinkNode(key, value);

        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;

        map.put(key, node);
    }



    private boolean isFull() {
        if (map.size() >= capacity)
            return true;
        return false;
    }

    private void invalidLRU() {
        if (capacity <= 0)
            return;
        int key = head.prev.key;
        removeNode(key);
    }

    public static void main(String[] args) {
        _146_LRUCache cache = new _146_LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);
        cache.put(3, 3);
    }

    private void printChain() {
        DLinkNode node = head.next;
        while (node != head) {
            System.out.print(node + " ->");
            node = node.next;
        }
        System.out.println();
    }
}
