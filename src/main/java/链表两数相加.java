import org.junit.Test;

/**
 * todo 描述作用
 *
 * @author 徐凌峰
 * @date 2020/1/6
 */
public class 链表两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        ListNode dummyNode = new ListNode(0);
        ListNode head = dummyNode;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = 0;
            int y = 0;
            if (l1 != null) {
                x = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                y = l2.val;
                l2 = l2.next;
            }
            int z = (x + y + carry);
            dummyNode.next = new ListNode(z % 10);
            dummyNode = dummyNode.next;
            carry = z >= 10 ? 1 : 0;
        }
        if (carry > 0) {
            dummyNode.next = new ListNode(carry);
        }
        return head.next;
    }


    @Test
    public void test() {
        ListNode l1 = new ListNode(1);
//        ListNode l2 = new ListNode(7);
//        ListNode l3 = new ListNode(6);
//        l1.next=l2;
//        l2.next=l3;


        ListNode l4 = new ListNode(9);
        ListNode l5 = new ListNode(9);
//        ListNode l6 = new ListNode(3);
        l4.next = l5;
//        l5.next=l6;

        System.out.println(addTwoNumbers(l1, l4));


    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
