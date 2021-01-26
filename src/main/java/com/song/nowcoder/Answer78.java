package com.song.nowcoder;

/**
 * @author yuanpeng.song
 * @createTime 2021/1/25
 * @description 输入一个链表，反转链表后，输出新链表的表头。
 * Laughter is poison to fear.
 */
public class Answer78 {
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        while (head!= null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
/***
 *题目描述
 * 输入一个链表，反转链表后，输出新链表的表头。
 * 示例1
 * 输入
 * 复制
 * {1,2,3}
 * 返回值
 * 复制
 * {3,2,1}
 */
