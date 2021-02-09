package 动态规划;

import org.junit.Test;

/**
 * @author XuLingfeng
 * @Description 一句话描述
 * @date 2021/1/13.22:24
 */
public class 走格子 {

    public int countWays(int x, int y) {
        int[][] dp = new int[x][y];
        for (int i = 0; i < x; ++i) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < y; ++i) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < x; ++i) {
            for (int j = 1; j < y; ++j) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[x - 1][y - 1];
    }

    public int countWays2(int x, int y) {
        if (x == 1 || y == 1) {
            return 1;
        }
        return countWays2(x - 1, y) + countWays2(x, y - 1);
    }

    @Test
    public void test() {
        System.out.println(countWays2(10, 5));
    }

}
