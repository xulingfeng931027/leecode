package linked;

import java.util.HashMap;
import java.util.Map;

/**
 * 判断环形链表方法
 *
 * @author 逼哥
 * @date 2019/9/30
 */
public class CycleLinkedList {

    /**
     * 快慢指针法
     * 时间复杂度O(n) 空间O(1)
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null)
            return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while (slow != fast) {
            if (fast == null || fast.next == null)
                return false;
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l2;
        CycleLinkedList cycleLinkedList = new CycleLinkedList();
        cycleLinkedList.detectCycle2(l1);
    }

    public ListNode detectCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        do {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 求两个链表的相交链表
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<Integer, ListNode> map = new HashMap<>();
        while (headA != null) {
            map.put(headA.val, headA);
            headA = headA.next;
        }
        while (headB != null) {
            ListNode listNode = map.get(headB.val);
            if (listNode != null) {
                return listNode;
            }
            headB = headB.next;
        }
        return null;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
