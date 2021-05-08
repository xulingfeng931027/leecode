package 动态规划;

import org.junit.Test;

/**
 * @author XuLingfeng
 * @Description 一句话描述
 * @date 2020/12/9
 */
public class 完全背包问题 {
    int[] wt;
    int[] val;


    /**
     * @param W   最大重量
     * @param wt  重量数组
     * @param val 价值数组
     * @return
     */
    public int bagProblem(int W, int[] wt, int[] val) {
        this.wt = wt;
        this.val = val;
        int[][] dp = new int[wt.length + 1][W + 1];
        for (int i = 1; i <= wt.length; i++) {
            for (int j = 1; j <= W; j++) {
                if (j < wt[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - wt[i - 1]] + val[i - 1]);
                }
            }
        }
        return dp[wt.length][W];
    }


    @Test
    public void test() {
        System.out.println(bagProblem(4, new int[]{2, 3, 1}, new int[]{4, 3, 2}));
    }
}
