package linked;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 判断环形链表方法
 *
 * @author 逼哥
 * @date 2019/9/30
 */
public class CycleLinkedList {

    /**
     * 遍历法,出现重复的说明有环啦
     * 需要遍历,时间复杂度O(n),空间复杂O(n)
     */
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        // 用set的去重可以节省空间
        Set<ListNode> set = new HashSet<>();
        set.add(head);
        while (head.next != null) {
            ListNode next = head.next;
            if (set.contains(next)) {
                return true;
            } else {
                set.add(next);
            }
            head = next;
        }
        return false;
    }

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

    /**
     * 输出环形链表中环链接的第一个节点 若不存在返回null
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;
        // 用set的去重可以节省空间
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
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
