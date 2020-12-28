package com.song.leetcode.answer;

/**
 * @ClassName Answer142
 * @Description Valar Morghulis.Valar Dohaeris
 * @Author songyp
 * @Date 2020-12-26 12:54
 */
public class Answer142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null){
            return null;
        }

        ListNode slow = head,fast = head;
        while (fast != null){
            slow = head.next;
            if (fast.next != null){
                fast = fast.next.next;
            }else {
                return null;
            }
            if (slow == fast){
                ListNode ptr = head;
                while (ptr != slow){
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 * <p>
 * 说明：不允许修改给定的链表。
 * <p>
 * 进阶：
 * <p>
 * 你是否可以使用 O(1) 空间解决此题？
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */