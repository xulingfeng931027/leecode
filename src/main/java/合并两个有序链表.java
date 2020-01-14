//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
// 示例：
//
//输入：1->2->4, 0->3->4
//输出：1->1->2->3->4->4
//
// Related Topics 链表


//leetcode submit region begin(Prohibit modification and deletion)

import org.junit.Test;

import java.util.StringJoiner;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class 合并两个有序链表 {
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        if (l1 == null && l2 == null) {
            return null;
        }
        while (l1 != null && l2 != null) {
            int val = l1.val;
            if (val > l2.val) {
                val = l2.val;
                l2 = l2.next;
            } else {
                l1 = l1.next;
            }
            dummy.next = new ListNode(val);
            dummy = dummy.next;
        }
        dummy.next = l1 == null ? l2 : l1;
        return head.next;
    }

    //递归解法
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        /*
        1.结束条件:当l1或者l2为null时  返回对应的链表
        2.子问题:当l1.val<l2.val 时,将l1的这个节点摘下来,同时移动l1指针再递归调用
         */
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            //将较小元素的节点斩下来,同时跟新链表相连
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

    @Test
    public void test() {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(8);
        ListNode l3 = new ListNode(9);
        l1.next = l2;
        l2.next = l3;


        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(2);
        ListNode l6 = new ListNode(6);
        l4.next = l5;
        l5.next = l6;

        System.out.println(mergeTwoLists1(l1, l4));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

