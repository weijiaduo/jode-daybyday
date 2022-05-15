package com.wjd.algorithm.practice.leetcode.structure;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        this(x, null);
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode build(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        ListNode head = null;
        for (int i = values.length - 1; i >= 0; i--) {
            head = new ListNode(values[i], head);
        }
        return head;
    }

    public String string() {
        ListNode p = this;
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        while (p != null) {
            sb.append(p.val).append(',');
            p = p.next;
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(']');
        return sb.toString();
    }

    @Override
    public String toString() {
        return "" + val;
    }
}
