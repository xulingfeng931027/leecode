package linked;

import org.junit.Test;

/**
 * 反转单链表
 *
 * @author 逼哥
 * @date 2019/10/1 1->2->3->null 变成3->2->1->null
 */
public class ReverseLinked {

    @Test public void test() {
        ListNode node6 = new ListNode(6, null);
        ListNode node5 = new ListNode(5, node6);

        ListNode node4 = new ListNode(5, node5);

        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(5, node3);
        ListNode node1 = new ListNode(1, node2);

        System.out.println(cleanNodes(node1));
    }

    //空间o(1) 时间o(n)
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newNode = null;
        while (head != null) {
            // 临时节点，暂存当前节点的下一节点
            ListNode nextTemp = head.next;
            // 将当前节点的下一节点指向新节点,这样就将新节点跟摘出来的原节点连上了
            head.next = newNode;
            // 将新节点的指针指向当前头节点.
            newNode = head;
            // 沿着临时指针继续往下走
            head = nextTemp;
        }
        return newNode;
    }

    /**
     * 删除指定值的节点
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        // 虚拟一个头结点便于处理
        ListNode virtual = new ListNode(-1);
        virtual.next = head;
        ListNode note = virtual;
        while (note.next != null) {
            if (note.next.val == val) {
                // 移除note这个元素 这里添加dummy节点可以防止只有链表中一个节点的时候报错.简化处理逻辑
                note.next = note.next.next;
            } else {
                note = note.next;
            }
        }
        return virtual.next;
    }

    /**
     * 将链表按索引的奇偶分组 先奇数再偶数
     *
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 奇数节点指针
        ListNode odd = head;
        // 偶数节点指针
        ListNode even = head.next;
        // 偶数节点头指针
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            // 奇数节点指向相邻偶数节点的下一个,即跳过了一个偶节点
            odd.next = even.next;
            // 奇数节点指针往前走
            odd = odd.next;
            // 偶数节点指向相邻奇数节点的下一个,即跳过了一个奇节点
            even.next = odd.next;
            // 偶数节点指针往前走
            even = even.next;
        }
        odd.next = evenHead;
        // 再把偶数节点塞在奇数节点的尾部,返回奇数节点头指针
        return head;
    }

    /**
     * @param head 头节点
     * @return boolean
     * @Description 判断是否为回文链表
     * @Author 逼哥 2019/10/1 16:37 新建
     * @Since Jdk1.7
     **/
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // 利用快慢指针找到中间节点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow指针指向中间节点 翻转链表前半部分
        ListNode prev = null;
        while (head != slow) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        } // 如果是奇数个节点，去掉后半部分的第一个节点。

        if (fast != null) {
            slow = slow.next;
        }
        // 回文校验
        while (prev != null) {
            if (prev.val != slow.val) {
                return false;
            }
            prev = prev.next;
            slow = slow.next;
        }
        return true;
    }

    /**
     * @return 合并后的头节点
     * @Description 合并两个单链表
     * @Author 逼哥 2019/10/1 16:37 新建
     * @Since Jdk1.7
     **/
    public ListNode mergeLinked(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(-1);
        dummy.next = node1;
        ListNode note = dummy;
        while (note.next != null) {
            note = note.next;
        }
        //找到最后一个节点
        note.next = node2;
        return dummy.next;
    }

    /**
     * 从链表中删除指定条件的元素,,比如值为5  返回剩下的头节点
     *
     * @param head
     * @return
     */
    public ListNode cleanNodes(ListNode head) {
        ListNode note = head;
        ListNode trail = null;
        while (note != null) {
            //遍历链表 暂存next节点
            ListNode next = note.next;
            if (note.val == 5) {
                //断掉该节点的next指针
                note.next = null;
                if (trail == null) {
                    head = next;
                } else {
                    trail.next = next;
                }
            } else {
                trail = note;
            }
            note = next;
        }
        return head;

    }

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode(int val) {
            this.val = val;
        }

        @Override public String toString() {
            return "ListNode{" + "val=" + val + ", next=" + next + '}';
        }
    }
}
