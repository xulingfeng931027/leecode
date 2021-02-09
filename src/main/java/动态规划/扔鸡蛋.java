package 动态规划;//你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N 共有 N 层楼的建筑。
//
// 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
//
// 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
//
// 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
//
// 你的目标是确切地知道 F 的值是多少。
//
// 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
//
//
//
//
//
//
// 示例 1：
//
// 输入：K = 1, N = 2
//输出：2
//解释：
//鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
//否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
//如果它没碎，那么我们肯定知道 F = 2 。
//因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。
//
//
// 示例 2：
//
// 输入：K = 2, N = 6
//输出：3
//
//
// 示例 3：
//
// 输入：K = 3, N = 14
//输出：4
//
//
//
//
// 提示：
//
//
// 1 <= K <= 100
// 1 <= N <= 10000
//
// Related Topics 数学 二分查找 动态规划
// 👍 528 👎 0


import org.junit.Test;

//leetcode submit region begin(Prohibit modification and deletion)
public class 扔鸡蛋 {
    //k个鸡蛋 n层楼
    public int superEggDrop(int K, int N) {
        Integer[][] memo = new Integer[K + 1][N + 1];
        return dp(K, N, memo);
    }

    //返回该状态的最少需要扔几次
    private int dp(int K, int N, Integer[][] memo) {
        if (K == 1) {
            return N;
        }
        if (N == 0) {
            return 0;
        }
        if (memo[K][N] != null) {
            return memo[K][N];
        }
        int result = Integer.MAX_VALUE;
        int low = 1;
        int high = N;
        while (low <= high) {
            //求最坏的情况
            int middle = (low + high) / 2;
            int broken = dp(K - 1, middle - 1, memo);
            int notBroken = dp(K, N - middle, memo);
            if (broken > notBroken) {
                high = middle - 1;
                result = Math.min(result, broken + 1);
            } else {
                low = middle + 1;
                result = Math.min(result, notBroken + 1);
            }
        }
        memo[K][N] = result;
        return result;
    }

    @Test
    public void test() {
        System.out.println(superEggDrop(2, 100));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
