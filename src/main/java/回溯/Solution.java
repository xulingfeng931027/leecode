package 回溯;//给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
//
// 注意: 
//
// 
// 每个数组中的元素不会超过 100 
// 数组的大小不会超过 200 
// 
//
// 示例 1: 
//
// 输入: [1, 5, 11, 5]
//
//输出: true
//
//解释: 数组可以分割成 [1, 5, 5] 和 [11].
// 
//
// 
//
// 示例 2: 
//
// 输入: [1, 2, 3, 5]
//
//输出: false
//
//解释: 数组不能分割成两个元素和相等的子集.
// 
//
// 
// Related Topics 动态规划 
// 👍 463 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int[] nums;
    private List<List<Integer>> childList = new ArrayList<>();
    private boolean result = false;
    /**
     * 给定数组的和
     */
    private int n;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.canPartition(new int[]{1, 5, 5, 11});
    }

    private boolean compute(List<Integer> tempList, int sum) {
        if (sum * 2 != n) {
            return false;
        }
        int otherSum = 0;
        for (int num : nums) {
            int index = tempList.indexOf(num);
            if (index != -1) {
                tempList.remove(index);
            } else {
                otherSum += num;
            }
        }
        return sum == otherSum;
    }

    public boolean canPartition(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        for (int num : nums) {
            n += num;
        }
        if (n % 2 != 0) {
            return false;
        }
        this.nums = nums;
        Arrays.sort(nums);
        backTrack(new ArrayList<>(), 0, 0);
        return result;
    }

    void backTrack(List<Integer> tempList, int start, int sum) {
        if (compute(new ArrayList<>(tempList), sum)) {
            result = true;
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            tempList.add(nums[i]);
            backTrack(tempList, i + 1, sum + nums[i]);
            tempList.remove(tempList.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
