import java.util.StringJoiner;

/**
 * 简单单链表定义
 *
 * @author 徐凌峰
 * @date 2020/1/10
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ListNode.class.getSimpleName() + "[", "]")
                .add("val=" + val)
                .add("next=" + next)
                .toString();
    }
}
