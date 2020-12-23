package com.song.leetcode.answer;

/**
 * @ClassName FindLastK
 * @Description Valar Morghulis.Valar Dohaeris
 * @Author songyp
 * @Date 2020-12-23 15:22
 */
public class FindLastK {

    public static void main(String[] args) {

    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode firstPointer = head, secondPointer = head;
        for (int i = 0; i < k; i++) {
            firstPointer = firstPointer.next;
        }
        while (firstPointer != null) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }

        return secondPointer;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}