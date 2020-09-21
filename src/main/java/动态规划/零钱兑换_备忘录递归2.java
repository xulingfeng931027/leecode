package 动态规划;//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。
//
//
//
// 示例 1:
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3
//解释: 11 = 5 + 5 + 1
//
// 示例 2:
//
// 输入: coins = [2], amount = 3
//输出: -1
//
//
//
// 说明:
//你可以认为每种硬币的数量是无限的。
// Related Topics 动态规划
// 👍 784 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class 零钱兑换_备忘录递归2 {


    int[] coins;

    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        return dp(dp, amount);
    }

    public int dp(int[] dp, int amount) {
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 4, 2};
        int amount = 10;
        System.out.println(new 零钱兑换_备忘录递归2().coinChange(coins, amount));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
