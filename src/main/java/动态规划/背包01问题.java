package 动态规划;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author XuLingfeng
 * @Description 一句话描述
 * @date 2020/12/9
 */
public class 背包01问题 {
    int[] wt;
    int[] val;
    int[][] dp;

    /**
     * @param W   最大重量
     * @param wt  重量数组
     * @param val 价值数组
     * @return
     */
    public int bagProblem(int W, int[] wt, int[] val) {
        this.wt = wt;
        this.val = val;
        //定义dp数组: dp[i][w] 表示对于仅选择前i个物品时,且当前剩余容量为w时 可以装的最大价值
        dp = new int[wt.length + 1][W + 1];
        int helper = helper(W);
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return helper;
    }

    private int helper(int W) {
        int n = val.length;
        //base case
        if (n == 0 || W == 0) {
            return 0;
        }
        //穷举所有状态 i从1开始
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                //剩余重量不够了
                if (j - wt[i - 1] < 0) {
                    // 这种情况下只能选择不装入背包
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //选了的话 可选个数-1 可选重量减少 整体价值增加
                    int choose = dp[i - 1][j - wt[i - 1]] + val[i - 1];
                    //不选的话  可选个数-1 可选重量和价值都不变
                    int noChoose = dp[i - 1][j];
                    dp[i][j] = Math.max(choose, noChoose);
                }
            }
        }
        return dp[n][W];
    }

    @Test
    public void test() {
        System.out.println(bagProblem(4, new int[]{2, 3, 1}, new int[]{4, 3, 2}));
    }
}
