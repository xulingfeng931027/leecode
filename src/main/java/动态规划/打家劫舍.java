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
        System.out.println(rob2(new int[]{2, 5, 6, 1, 9, 4, 3}));
    }

    public int rob2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int len = nums.length;
        return Math.max(helper(0, len - 2, nums), helper(1, len - 1, nums));
    }

    private int helper(int start, int end, int[] nums) {
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start+1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[end];
    }
}
