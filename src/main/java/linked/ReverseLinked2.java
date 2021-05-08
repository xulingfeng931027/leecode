package linked;//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表 
// 👍 710 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import org.junit.Test;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class ReverseLinked2 {
    public ListNode reverseBetween1(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode tail = dummy;
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }
        for (int i = 0; i < right; i++) {
            tail = tail.next;
        }
        ListNode next = tail.next;
        tail.next = null;
        ListNode start = pre.next;
        pre.next = reverse(start);
        start.next = next;
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        for (int i = 1; i < left; i++) {
            pre = pre.next;
            cur = cur.next;
        }
        for (int i = 0; i < right - left; i++) {
            ListNode removed = cur.next;
            cur.next = cur.next.next;
            removed.next = pre.next;
            pre.next = removed;
        }
        return dummy.next;


    }

    @Test
    public void test() {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        System.out.println(reverseBetween2(head1, 2, 4));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
