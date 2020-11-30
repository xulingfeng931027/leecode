//给定一个整数数组 nums，返回区间和在 [lower, upper] 之间的个数，包含 lower 和 upper。
//区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。
//
// 说明:
//最直观的算法复杂度是 O(n2) ，请在此基础上优化你的算法。
//
// 示例:
//
// 输入: nums = [-2,5,-1], lower = -2, upper = 2,
//输出: 3
//解释: 3个区间分别是: [0,0], [2,2], [0,2]，它们表示的和分别为: -2, -1, 2。
//
// Related Topics 排序 树状数组 线段树 二分查找 分治算法
// 👍 183 👎 0


import org.junit.Test;

//leetcode submit region begin(Prohibit modification and deletion)
public class 区间和个数 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int count = 0;
//        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];
            if (inRange(num, lower, upper)) {
                System.out.println(i+" "+i);
                count++;
            }
            for (int j = i + 1; j < nums.length; j++) {
                num += nums[j];
                if (inRange(num, lower, upper)) {
                    System.out.println(i+" "+j);
                    count++;
                }
            }
        }
        return count;
    }

    private boolean inRange(long num, int lower, int upper) {
        return num >= lower && num <= upper;
    }

    @Test
    public void test() {
        System.out.println(countRangeSum(new int[]{-2, 5, -1}, -2, 2));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
