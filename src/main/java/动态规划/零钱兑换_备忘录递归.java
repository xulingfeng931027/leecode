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
class 零钱兑换_备忘录递归 {


    int[] coins;

    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        int[] datas = new int[amount + 1];
        Arrays.fill(datas, amount + 1);
        return dp(datas, amount);
    }

    public int dp(int[] datas, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if (datas[amount] < datas.length) {
            return datas[amount];
        }
        int res = Integer.MAX_VALUE;
        for (int coinValue : coins) {
            int subProblem = dp(datas, amount - coinValue);
            if (subProblem == -1) {
                continue;
            }
            res = Math.min(res, 1 + subProblem);
        }
        res = res == Integer.MAX_VALUE ? -1 : res;
        datas[amount] = res;
        return res;
    }

    public static void main(String[] args) {
        int[] coins = {1, 4, 2};
        int amount = 10;
        System.out.println(new 零钱兑换_备忘录递归().coinChange(coins, amount));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
