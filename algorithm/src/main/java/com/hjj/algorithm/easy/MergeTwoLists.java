package com.hjj.algorithm.easy;

/**
 * 创建时间：2022/9/17
 * 作者：
 * 功能描述：合并两个顺序链表
 * 思路：循环判断两个链表节点的值大小，
 * 直到一方为空则将不为空的放到合并链表尾部
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }
        ListNode node = new ListNode();
        ListNode cur = node;
        do {
            if (list1.val < list2.val) {
                cur.next = list1;
                cur = cur.next;
                list1 = list1.next;
            } else {
                cur.next = list2;
                cur = cur.next;
                list2 = list2.next;
            }
        } while (list1 != null && list2 != null);
        if (list1 == null) {
            cur.next = list2;
        }

        if (list2 == null) {
            cur.next = list1;
        }
        return node.next;
    }

    public class ListNode {
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
}
