package linked;

/**
 * 单向链表实现
 *
 * @author 逼哥
 * @date 2019/9/26
 *       <p>
 *       Your MyLinkedList object will be instantiated and called as such:
 *       MyLinkedList obj = new MyLinkedList(); int param_1 = obj.get(index);
 *       obj.addAtHead(val); obj.addAtTail(val); obj.addAtIndex(index,val);
 *       obj.deleteAtIndex(index);
 */
public class MyLinkedList2 {

    private int size;
    private ListNode head;
    private ListNode tail;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList2() {
        // ListNode head = new ListNode(0);
        // ListNode tail = new ListNode(0);
        // head.next = tail;
        // head.prev = null;
        // tail.prev = head;
        // tail.next = null;
    }

    public static void main(String[] args) {
        MyLinkedList2 linkedList = new MyLinkedList2();
//        linkedList.addAtHead(1);
//        linkedList.addAtTail(3);
//        linkedList.addAtIndex(1, 2); // 链表变为1-> 2-> 3
//        System.out.println(linkedList.get(1));
//        linkedList.deleteAtIndex(1); // 现在链表是1-> 3
//        System.out.println(linkedList.get(1));
        linkedList.addAtHead(1);
        linkedList.deleteAtIndex(0);

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is
     * invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode listNode = head;
        while (index > 0) {
            listNode = listNode.next;
            index--;
        }
        return listNode.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After
     * the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        // 先new一个新节点
        ListNode newHead = new ListNode(val);
        newHead.next = head;
        if (head != null) {
            // 将原头部赋值给新结点的next
            head.prev = newHead;
            // 将新节点设置为头部
        } else {
            tail = newHead;
        }
        head = newHead;
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        final ListNode note = tail;
        final ListNode newNode = new ListNode(val);
        newNode.prev = tail;
        tail = newNode;
        if (note == null)
            head = newNode;
        else
            note.next = newNode;
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index
     * equals to the length of linked list, the node will be appended to the end of
     * linked list. If index is greater than the length, the node will not be
     * inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index <= 0) {
            // 在头部插入节点
            addAtHead(val);
        } else if (index == size) {
            // 在尾部插入节点
            addAtTail(val);
        } else if (index < size) {
            ListNode node = this.head;
            while (index > 1) {
                // 找到待添加的上一个节点位置,
                node = node.next;
                index--;
            }
            ListNode newNode = new ListNode(val);
            newNode.prev = node;
            newNode.next = node.next;
            node.next.prev = newNode;
            node.next = newNode;
            size++;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index == 0 && head != null) {
            head.prev = null;
            head = head.next;
            size--;
        } else if (index > 0 && index < size) {
            ListNode node = head;
            while (index > 0) {
                node = node.next;
                index--;
            }
            if (node.prev != null && node.next != null) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                size--;
            }
        }
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode prev;

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" + "val=" + val + ", next=" + next + ", prev=" + prev + '}';
        }
    }
}
