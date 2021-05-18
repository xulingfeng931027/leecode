package 动态规划;

import org.junit.Test;

/**
 * @author XuLingfeng
 * @Description 一句话描述
 * @date 2021/5/11.16:06
 */
public class 股票问题 {
    /**
     * @param n      天数
     * @param K      允许的交易次数
     * @param prices 股票价格数组
     * @return
     */
    public int maxProfit0(int n, int K, int[] prices) {
        int[][][] dp = new int[n + 1][K][2];
        dp[0][0][0] = 0;
        dp[0][0][1] = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Integer.MIN_VALUE;
        }

        for (int i = 1; i <= n; i++) {
            for (int k = 1; k < K; k++) {
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k][0] - prices[i]);
            }
        }
        return 0;
    }

    /**
     * k=1的场景
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
//        int[][] dp = new int[prices.length][2];
//        dp[0][0] = 0;
//        dp[0][1] = -prices[0];
        int dp0 = 0;
        int dp1 = -prices[0];
        for (int price : prices) {
//            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
//            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            dp0 = Math.max(dp0, dp1 + price);
            dp1 = Math.max(dp1, -price);
        }
        return dp0;
    }

    /**
     * k=无穷大的场景 k=k-1 所以k可以约掉
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
//        int[][] dp = new int[prices.length][2];
//        dp[0][0] = 0;
//        dp[0][1] = -prices[0];
        int dp0 = 0;
        int dp1 = -prices[0];
        for (int price : prices) {
//            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
//            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp0 = Math.max(dp0, dp1 + price);
            dp1 = Math.max(dp1, dp0 - price);
        }
        return dp0;
    }

    /**
     * k=无穷大的场景 k=k-1 所以k可以约掉
     * 带一天的冷却期 卖掉之后要等一天才能买
     *
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
//        int[][] dp = new int[prices.length][2];
//        dp[0][0] = 0;
//        dp[0][1] = -prices[0];
//        dp[1][0] = Math.max(0, prices[1] - prices[0]);
//        dp[1][1] = Math.max(-prices[0], -prices[1]);
        int dp0 = 0;
        int dp1 = -prices[0];
        int dp2 = 0;
        for (int price : prices) {
//            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
//            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
            int temp = dp0;
            dp0 = Math.max(dp0, dp1 + price);
            dp1 = Math.max(dp1, dp2 - price);
            dp2 = temp;
        }
        return dp0;
    }

    /**
     * k=无穷大的场景 k=k-1 所以k可以约掉
     * 卖的时候带手续费
     *
     * @param prices
     * @return
     */
    public int maxProfit4(int[] prices, int fee) {
//        int[][] dp = new int[prices.length][2];
//        dp[0][0] = 0;
//        dp[0][1] = -prices[0];
//        dp[1][0] = Math.max(0, prices[1] - prices[0]);
//        dp[1][1] = Math.max(-prices[0], -prices[1]);
        int dp0 = 0;
        int dp1 = -prices[0];
        int dp2 = 0;
        for (int price : prices) {
//            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
//            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
            int temp = dp0;
            dp0 = Math.max(dp0, dp1 + price - fee);
            dp1 = Math.max(dp1, dp2 - price);
            dp2 = temp;
        }
        return dp0;
    }

    /**
     * k=2的场景 不能忽略
     *
     * @param prices
     * @return
     */
    public int maxProfit5(int[] prices, int K) {
        int n = prices.length;
        int[][][] dp = new int[prices.length][K+1][2];
        for (int i = 0; i < n; i++) {
            for (int k = 1; k <= K; k++) {
                if (i == 0) {
                    dp[0][k][0] = 0;
                    dp[0][k][1] = -prices[0];
                } else {
                    dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                    //买的时候需要k-1
                    dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k-1][0] - prices[i]);
                }
            }
        }
        return dp[n - 1][K][0];
    }


    @Test
    public void test() {
        System.out.println(maxProfit5(new int[]{3, 3, 5, 0, 0, 3, 1, 4}, 2));
    }


}
