package 回溯;//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//  -2 -1 0 0  1 2
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针 
// 👍 627 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
public class 四数之和 {
    List<List<Integer>> result = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    private int target;
    private int[] nums;

    public static void main(String[] args) {
        四数之和 solution = new 四数之和();
        solution.fourSum(new int[]{1, 0, -1, 0, -2, 2, 3, -4, 5}, 0);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        for (int num : nums) {
            map.put(target - num, num);
        }
        this.target = target;
        Arrays.sort(nums);
        this.nums = nums;
        backTrack(new ArrayList<>(), 0, 0);
        return result;
    }

    void backTrack(List<Integer> tempList, int start, int sum) {
        if (tempList.size() == 4 && sum == target) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        if (tempList.size() == 3) {
            Integer fourth = map.get(sum);
            if (fourth != null) {
                tempList.add(fourth);
                result.add(new ArrayList<>(tempList));
            }
            return;
        }
        for (int i = start; i < nums.length; i++) {
            //去重 基操
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            //剪枝
            if (nums.length - i < 4 - tempList.size()) {
                return;
            }
            //如果后面一个数*剩余的个数的和都还大了
            if (i < nums.length - 1 && sum + nums[i] + (3 - tempList.size()) * nums[i + 1] > target) {
                continue;
            }
            //如果最后的数*剩余的个数的和都还小了
            if (i < nums.length - 1 && sum + nums[i] + (3 - tempList.size()) * nums[nums.length - 1] < target) {
                continue;
            }

            tempList.add(nums[i]);
            backTrack(tempList, i + 1, sum + nums[i]);
            tempList.remove(tempList.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
