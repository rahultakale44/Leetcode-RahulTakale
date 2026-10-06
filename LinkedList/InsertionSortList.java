
public class InsertionSortList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode insertionSortList(ListNode head) {

        ListNode dummy = new ListNode(0);
        ListNode current = head;

        while (current != null) {

            // Save next node before changing current.next
            ListNode next = current.next;

            // Find insertion position
            ListNode prev = dummy;

            while (prev.next != null && prev.next.val <= current.val) {
                prev = prev.next;
            }

            // Insert current
            current.next = prev.next;
            prev.next = current;

            current = next;
        }

        return dummy.next;
    }

    static ListNode createList(int[] values) {

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }

        return dummy.next;
    }

    static void printList(ListNode head) {

        while (head != null) {
            System.out.print(head.val);

            if (head.next != null) {
                System.out.print(" -> ");
            }

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        int[] values = {4, 2, 1, 3};

        ListNode head = createList(values);

        System.out.println("Original List:");
        printList(head);

        head = insertionSortList(head);

        System.out.println("Sorted List:");
        printList(head);
    }
}