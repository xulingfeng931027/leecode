import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * todo 描述作用
 *
 * @author 徐凌峰
 * @date 2020/1/9
 */
public class 爬楼梯 {
    //假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
// 注意：给定 n 是一个正整数。
//
// 示例 1：
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶
//
// 示例 2：
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
//
// Related Topics 动态规划

    private Map<Integer, Integer> map = new HashMap<>();

    //leetcode submit region begin(Prohibit modification and deletion)
    public int climbStairs1(int n) {
        if (n == 1 || n == 2)
            return n;
        int first = 1;
        int second = 2;
        for (int i = 2; i < n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    public int climbStairs2(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        Integer result = map.get(n);
        if (result != null) {
            return result;
        }
        int first = climbStairs2(n - 1);
        int second = climbStairs2(n - 2);
        map.put(n, first + second);
        return first + second;
    }

    public int climbStairs3(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return climbStairs3(n - 1) + climbStairs3(n - 2);
    }

    public int climbStairs4(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void test() {
//        System.out.println(climbStairs1(10));
//        System.out.println(climbStairs2(10));
//        System.out.println(climbStairs3(10));
        System.out.println(climbStairs4(20));

    }
}
