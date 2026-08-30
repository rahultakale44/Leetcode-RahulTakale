import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> cache;

    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {

        this.capacity = capacity;
        cache = new HashMap<>();

        // Dummy nodes
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {

        // Key does not exist
        if (!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);

        // Move accessed node to front
        remove(node);
        insertAtFront(node);

        return node.value;
    }

    public void put(int key, int value) {

        // Key already exists
        if (cache.containsKey(key)) {

            Node node = cache.get(key);

            // Update value
            node.value = value;

            // Move to front (Most Recently Used)
            remove(node);
            insertAtFront(node);

        } else {

            // Create new node
            Node newNode = new Node(key, value);

            // Add to HashMap
            cache.put(key, newNode);

            // Add to front
            insertAtFront(newNode);

            // Remove least recently used node
            if (cache.size() > capacity) {

                Node lruNode = tail.prev;

                remove(lruNode);
                cache.remove(lruNode.key);
            }
        }
    }

    // Insert node after head
    private void insertAtFront(Node node) {

        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    // Remove node from doubly linked list
    private void remove(Node node) {

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Main method for VS Code testing
    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);

        System.out.println(cache.get(1)); // 1

        cache.put(3, 3);

        System.out.println(cache.get(2)); // -1

        cache.put(4, 4);

        System.out.println(cache.get(1)); // -1
        System.out.println(cache.get(3)); // 3
        System.out.println(cache.get(4)); // 4
    }
}