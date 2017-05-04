package com.ashu.utils.ds.LinkedList;

/**
 * Created by mishra.ashish@icloud.com
 */
public class DetectLoop {

    static Node head;

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Function that detects loop in the list
    void detectAndRemoveLoop(Node node) {
        Node slow = node;
        Node fast = node.next;


        if (hasLoop(node)) {

            slow = node;
            while (slow != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }

            // since fast->next is the looping point
            fast.next = null; // remove loop

        }
    }


    boolean hasLoop(Node first) {

        Node slow = first;
        Node fast = first;

        while(fast != null && fast.next != null) {
            slow = slow.next;          // 1 hop
            fast = fast.next.next;     // 2 hops

            if (slow == fast) { // fast caught up to slow, so there is a loop
                System.out.println("Detected cycle ! " + slow.data + " hits " + fast.data);
                return true;
            }
        }
        return false;  // fast reached null, so the list terminates
    }

    // Function to print the linked list
    void printList(Node node) {
        System.out.println("list ");
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    // Driver program to test above functions
    public static void main(String[] args) {

        DetectLoop list = new DetectLoop();
        list.head = new Node(50);
        list.head.next = new Node(20);
        list.head.next.next = new Node(15);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(10);

        // Creating a loop for testing
        head.next.next.next.next.next = head.next.next;

        System.out.println("Linked List before detecting loop : ");
        //list.printList(head);

        //System.out.println("has loop ?  " + list.hasLoop(head));
        list.detectAndRemoveLoop(head);

        System.out.println("Linked List after detecting and removing  loop : ");
        //list.printList(head);
    }
}
