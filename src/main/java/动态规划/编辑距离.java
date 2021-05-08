package 动态规划;

/**
 * @author XuLingfeng
 * @Description 一句话描述
 * @date 2021/2/4.13:07
 */
//给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。 
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
//
// 
//
// 提示： 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 和 word2 由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 
// 👍 1380 👎 0


import org.junit.Test;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
public class 编辑距离 {
    String word1;
    String word2;
    Integer[][] dp;

    public int minDistance(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
        dp = new Integer[word1.length() + 1][word2.length() + 1];
        int helper = helper(word1.length() - 1, word2.length() - 1);
        for (Integer[] integers : dp) {
            System.out.println(Arrays.toString(integers));
        }
        return helper;
    }

    //返回最小步数
    private int helper(int index1, int index2) {
        if (dp[index1 + 1][index2 + 1] != null) {
            return dp[index1 + 1][index2 + 1];
        }
        if (index1 == -1) {
            dp[0][index2 + 1] = index2 + 1;
            return index2 + 1;
        }
        if (index2 == -1) {
            dp[index1 + 1][0] = index1 + 1;
            return index1 + 1;
        }
        if (word1.charAt(index1) == word2.charAt(index2)) {
            dp[index1][index2] = helper(index1 - 1, index2 - 1);
            return dp[index1][index2];
        } else {
            //替换 插入 删除
            int t1 = helper(index1 - 1, index2 - 1) + 1;
            int t2 = helper(index1 - 1, index2) + 1;
            int t3 = helper(index1, index2 - 1) + 1;
            dp[index1 + 1][index2 + 1] = Math.min(t1, Math.min(t2, t3)); //插入
            return dp[index1 + 1][index2 + 1];
        }
    }

    public int minDistance2(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] =i;
        }
        for (int i = 1; i < dp[0].length; i++) {
            dp[1][0] = i;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int t1 =dp[i-1][j] + 1;
                    int t2 =dp[i-1][j-1] + 1;
                    int t3 = dp[i][j - 1] + 1;
                    dp[i][j] = Math.min(t1, Math.min(t2, t3));
                }
            }
        }
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return dp[word1.length()][word2.length()];
    }


    @Test
    public void test() {
        System.out.println(minDistance2("horse", "ros"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

