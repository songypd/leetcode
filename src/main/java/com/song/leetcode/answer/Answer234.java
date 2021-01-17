package com.song.leetcode.answer;

/**
 * @author yuanpeng.song
 * @createTime 2021/1/17
 * @description https://leetcode-cn.com/problems/palindrome-linked-list/
 * Laughter is poison to fear.
 */
public class Answer234 {
    public boolean isPalindrome(ListNode head) {
        //判断非空
        if (head == null || head.next == null){
            return Boolean.TRUE;
        }
        //快慢指针
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        //此处判断长度的奇偶数的情况
        if (fast != null){
            slow = slow.next;
        }

        //反转中间点之后的链表
        slow = reverse(slow);

        fast = head;

        while (slow != null){
            if (fast.val != slow.val){
                return Boolean.FALSE;
            }
            fast = fast.next;
            slow = slow.next;
        }

        return true;
    }

    private ListNode reverse(ListNode node){
        ListNode pre = null;
        while(node != null ){
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;

    }
}

/**
 * 执行结果：
 * 通过
 * 显示详情
 * 执行用时：
 * 1 ms
 * , 在所有 Java 提交中击败了
 * 99.95%
 * 的用户
 * 内存消耗：
 * 40.9 MB
 * , 在所有 Java 提交中击败了
 * 78.67%
 * 的用户
 * */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * 并未要求不能改变链表结构
 * 可以改变链表的结构
 *
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
