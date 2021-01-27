package 动态规划;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author XuLingfeng
 * @Description 一句话描述
 * @date 2020/12/7
 */
public class 最长递增子序列 {

    public int longestIndex(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int result = 0;
        for (int j : dp) {
            result = Math.max(result, j);
        }
        return result;
    }

    @Test
    public void test() {
        System.out.println(longestIndex(new int[]{1, 4, 3, 4, 2}));

    }
}
