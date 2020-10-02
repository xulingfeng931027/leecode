package 回溯;//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
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


import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class 零钱兑换 {


    int res = Integer.MAX_VALUE;
    int[] coins;
    //回溯算法 dfs
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        this.coins = coins;
        backTrace(new LinkedList<>(), amount);
        return res;
    }

    public void backTrace(LinkedList<Integer> temp, int amount) {
        int sum = temp.stream().mapToInt(e -> e).sum();
        //结束条件
        if (sum == amount) {
            res = Math.min(res, temp.size());
            return;
        }
        for (Integer coin : coins) {
            //排除不合法选择
            if (sum + coin > amount) {
                continue;
            }
            //做选择
            temp.add(coin);
            //递归
            backTrace(temp, amount);
            //撤销选择
            temp.removeLast();
        }
        if (res == Integer.MAX_VALUE) {
            res = -1;
        }
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 3, 4, 5};
        int amount = 11;
        System.out.println(new 零钱兑换().coinChange(coins, amount));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
