package com.song.leetcode.answer;

/**
 * @author yuanpeng.song
 * @createTime 2021/1/15
 * @description https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * Laughter is poison to fear.
 */
public class Answer160 {
    /**
     * 解题思路就很简单，单链表从相交节点开始，之后的节点相同
     * <p>
     * 链表A： a+c, 链表B : b+c. a+c+b+c = b+c+a+c
     * 走到尽头见不到你，于是走过你来时的路，等到相遇时才发现，你也走过我来时的路。
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }

        return p1;
    }

}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 * <p>
 * 编写一个程序，找到两个单链表相交的起始节点。
 * <p>
 * 注意：
 * <p>
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 编写一个程序，找到两个单链表相交的起始节点。
 * <p>
 * 注意：
 * <p>
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 编写一个程序，找到两个单链表相交的起始节点。
 * <p>
 * 注意：
 * <p>
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 *编写一个程序，找到两个单链表相交的起始节点。
 *
 * 注意：
 *
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */