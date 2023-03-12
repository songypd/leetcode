package com.song.leetcode.answer;


import com.alibaba.fastjson.JSON;

/**
 * @author yuanpeng.song
 * @createTime 2022/2/23
 * @description 两数相加
 * Laughter is poison to fear.
 */
public class Q2 {
    /**
     * 题目描述
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     * <p>
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * <p>
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

//        new Q2().addTwoNumbersV2(l1,l2);
        System.out.println(JSON.toJSONString(new Q2().addTwoNumbers(l1,l2)));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;
            int sum = v1 + v2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            if (carry > 0) {
                tail.next = new ListNode(sum / 10);
            }
        }
        return head;
    }


    /**
     * 这个方法的问题在于，每次都会给head赋值，导致每次head都是下一个节点的值，最终只会输出最后一个节点的值
     * 所以诀窍是，链表输出头节点的是要加上一个临时节点，用于给head节点的下节点赋值
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbersV2(ListNode l1, ListNode l2) {
        ListNode head = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;
            int sum = v1 + v2 + carry;
            if (head == null) {
                head = new ListNode(sum % 10);
            } else {
                head.next = new ListNode(sum % 10);
                head = head.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            if (carry > 0) {
                head.next = new ListNode(sum / 10);
            }
        }
        return head;
    }

}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}