//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
//
//
// push(x) —— 将元素 x 推入栈中。
// pop() —— 删除栈顶的元素。
// top() —— 获取栈顶元素。
// getMin() —— 检索栈中的最小元素。
//
//
//
//
// 示例:
//
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
//
//
//
//
// 提示：
//
//
// pop、top 和 getMin 操作总是在 非空栈 上调用。
//
// Related Topics 栈 设计
// 👍 634 👎 0


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
public class MinStack {

    private Stack<Integer> mainStack;

    private Stack<Integer> assistStack;


    /**
     * initialize your data structure here.
     */
    public MinStack() {
        mainStack = new Stack<>();
        assistStack = new Stack<>();
    }

    public void push(int x) {
        mainStack.add(x);
        if (!assistStack.isEmpty()) {
            int top = assistStack.peek();
            if (x < top) {
                assistStack.add(x);
            }
        } else {
            assistStack.add(x);
        }
    }

    public void pop() {
        if (mainStack.isEmpty()) {
            return;
        }
        int remove = mainStack.pop();

        if (remove == assistStack.peek()) {
            assistStack.pop();
        }
    }

    public int top() {
        if (mainStack.isEmpty()) {
            return 0;
        }
        return mainStack.pop();
    }

    public int getMin() {
        return assistStack.get(assistStack.size() - 1);
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(3);
        minStack.push(2);
        minStack.push(4);
        minStack.push(1);
        minStack.pop();
        System.out.println(minStack.getMin());

    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)
