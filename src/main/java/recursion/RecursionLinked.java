package recursion;


/**
 * todo 描述作用
 *
 * @author 逼哥
 * @date 2019/9/14 给定链表，交换每两个相邻节点并返回其头节点。
 * <p>例如，对于列表 1-> 2 -> 3 -> 4，我们应当返回新列表 2 -> 1 -> 4 -> 3 的头节点。
 * <p>我们可以定义函数 swap(head) 以实现解决方案，其中输入的参数 head 指向链表的头节点。
 * 而该函数应当返回将链表中每两个相邻节点交换后得到的新列表的头节点 head 。
 * <p>按照我们上面列出的步骤，我们可以按下面的流程来实现函数：
 * <p>首先，我们交换列表中的前两个节点，也就是 head 和 head.next； 然后我们以 swap(head.next.next)
 * 的形式调用函数自身，以交换头两个节点之后列表的其余部分。
 * 最后，我们将步骤（2）中的子列表的返回头与步骤（1）中交换的两个节点相连，以形成新的链表。
 */
public class RecursionLinked {
    private static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(head.next.next);
        next.next = head;
        return next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
//        listNode4.next = listNode5;
//        listNode5.next = listNode6;


        System.out.println(swapPairs(listNode1));
    }

    static class ListNode {
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
