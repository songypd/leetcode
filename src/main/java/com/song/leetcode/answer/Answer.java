package com.song.leetcode.answer;

/**
 * @ClassName Answer
 * @Description Valar Morghulis.Valar Dohaeris
 * @Author songyp
 * @Date 2020-12-24 21:13
 */
public class Answer {


    /**
     * 有序添加
     *
     * @param head
     * @param val
     */
    private void add(ListNode2 head, int val) {
        ListNode2 node = head;
        while (node != null) {
            if (node.getNext() == null) {
                if (val < node.getNext().getVal() && val>node.getVal() ){
                    ListNode2 n = new ListNode2();
                    n.setBefore(node);
                    n.setNext(null);
                    node.setNext(n);
                }

            }
            node = node.getNext();
        }

    }

    /**
     * 删除等值元素
     *
     * @param head
     */
    private void deleteSame(ListNode2 head) {
        ListNode2 node = head;

        while (node != null&&node.getNext() != null) {
            if (node.getVal() == node.getNext().getVal()) {
                node.setNext(node.getNext().getNext());
            }
            node = node.getNext();
        }


        node.setBefore(node.getBefore().getBefore());
    }


}

class ListNode2 {
    private int val;
    private ListNode2 next;
    private ListNode2 before;

    public int getVal() {
        return val;
    }

    public ListNode2 getNext() {
        return next;
    }

    public ListNode2 getBefore() {
        return before;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setNext(ListNode2 next) {
        this.next = next;
    }

    public void setBefore(ListNode2 before) {
        this.before = before;
    }
}
/**
 * 1；实现一个双向链表的有序添加
 * 2；实现等值的删除
 */













