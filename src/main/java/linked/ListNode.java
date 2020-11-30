package linked;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) { val = x; }

    ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }

}