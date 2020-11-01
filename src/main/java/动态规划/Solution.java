package 动态规划;//给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选
//择一个符号添加在前面。 
//
// 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。 
//
// 
//
// 示例： 
//
// 输入：nums: [1, 1, 1, 1, 1], S: 3
//输出：5
//解释：
//
//-1+1+1+1+1 = 3
//+1-1+1+1+1 = 3
//+1+1-1+1+1 = 3
//+1+1+1-1+1 = 3
//+1+1+1+1-1 = 3
//
//一共有5种方法让最终目标和为3。
// 
//
// 
//
// 提示： 
//
// 
// 数组非空，且长度不会超过 20 。 
// 初始的数组的和不会超过 1000 。 
// 保证返回的最终结果能被 32 位整数存下。 
// 
// Related Topics 深度优先搜索 动态规划 
// 👍 442 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int[] nums;
    private Map<String, Integer> map = new HashMap<>();

    public int findTargetSumWays(int[] nums, int S) {
        this.nums = nums;
        return dp(0, S);
    }

    int dp(int i, int result) {
        if (i == nums.length) {
            if (result == 0) {
                return 1;
            }
            return 0;
        }
        String s = i + "," + result;
        if (map.containsKey(s)) {
            return map.get(s);
        }
        //穷举
        int tempResult = dp(i + 1, result - nums[i]) + dp(i + 1, result + nums[i]);
        map.put(s, tempResult);
        return tempResult;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
