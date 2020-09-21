import java.util.Arrays;
import java.util.Stack;

/**
 * 单调栈解决下一个最大元素的问题
 * @author Xulingfeng
 * @description
 * @date 2020/9/14
 */
public class 找高个儿 {

    public int[] solotion(int[] a) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= a[i]) {
                stack.pop();
            }
            ans[i] = stack.empty() ? -1 : stack.peek();
            stack.push(a[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        找高个儿 test = new 找高个儿();
        System.out.println(Arrays.toString(test.solotion(new int[]{2,1, 3, 4, 5})));
    }
}
