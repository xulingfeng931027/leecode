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
public class MyLinkedList {

    private int size;
    private Node head;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2); // 链表变为1-> 2-> 3
        System.out.println(linkedList.get(1));
        linkedList.deleteAtIndex(1); // 现在链表是1-> 3
        System.out.println(linkedList.get(1));
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is
     * invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        Node node = head;
        while (index > 0) {
            node = node.next;
            index--;
        }
        return node.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After
     * the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        // 先new一个新节点
        Node head = new Node(val);
        // 将原头部赋值给新结点的next
        head.next = this.head;
        // 将新节点设置为头部
        this.head = head;
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        addAtIndex(size, val);
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
        } else if (index <= size) {
            Node node = this.head;
            while (index > 1) {
                // 找到该位置的上一个节点
                node = node.next;
                index--;
            }
            Node newNode = new Node(val);
            newNode.next = node.next;
            node.next = newNode;
            size++;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index == 0) {
            Node head = this.head;
            this.head = head.next;
            head = null;
            size--;
        } else if (index > 0 && index < size) {
            Node node = head;
            while (index > 1) {
                node = node.next;
                index--;
            }
            node.next = node.next.next;
            size--;
        }
    }

    private static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
