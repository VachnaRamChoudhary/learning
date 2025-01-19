package com.vachna.utill;

import com.vachna.modals.ListNode;

import javax.management.openmbean.InvalidKeyException;
import java.util.ArrayList;

public interface HelperUtil {

    static ListNode createLinkedList(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        if(n >= 0){
            for(int i = 0; i < n; i++){
                list.add(i+1);
            }
        } else {
            for(int i = Math.abs(n); i > 0; i--){
                list.add(i);
            }
        }
        return createLinkedList(list);

    }
    static ListNode createLinkedList(ArrayList<Integer> list){
        int n = list.size();
        if (n == 0) {
            return null;
        }

        ListNode head = new ListNode(list.getFirst()); // Create the first node
        ListNode current = head;

        for (int i = 1; i < n; i++) {
            current.next = new ListNode(list.get(i)); // Create and link the next node
            current = current.next;
        }

        return head;
    }

    static ListNode getLastNode(ListNode head){
        while(head.next != null) head = head.next;
        return head;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    /**
     * Ex: 1, 2, 3, 2, 1
     * Ex: 1, 2, 2, 1
     */
    static ListNode findMidOfLinkedList(ListNode head){
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.next;
    }

    static <T> void print(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println();
    }

    static void print(int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println();
    }

}
