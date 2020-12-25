package com.song.leetcode.answer;

/**
 * @ClassName Answer83
 * @Description Valar Morghulis.Valar Dohaeris
 * @Author songyp
 * @Date 2020-12-24 13:13
 * 删除排序链表中的重复元素
 */
public class Answer83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while (node != null&&node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            }else {
                node = node.next;
            }

        }
        return head;
    }
}
/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */