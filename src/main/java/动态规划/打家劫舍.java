package 动态规划;

import org.junit.Test;

/**
 * @author XuLingfeng
 * @Description 一句话描述
 * @date 2020/12/18
 */
public class 打家劫舍 {
    public int rob(int[] nums) {
        int n = nums.length;
        // dp[i] = x 表示：
        // 从第 i 间房子开始抢劫，最多能抢到的钱为 x
        // base case: dp[n] = 0
        int dp0 = 0, dp1 = 0, dp2 = 0;
        for (int i = n - 1; i >= 0; i--) {
            dp0 = Math.max(dp1, nums[i] + dp2);
            dp2 = dp1;
            dp1 = dp0;
        }
        System.out.println(dp0);
        return dp0;
    }

    @Test
    public void test() {
        rob(new int[]{1, 2, 4, 3, 8, 6, 5});

    }
}
