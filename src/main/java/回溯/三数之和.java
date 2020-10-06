package 回溯;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
public class 三数之和 {
    List<List<Integer>> result = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    private int target;
    private int[] nums;

    public static void main(String[] args) {
        三数之和 solution = new 三数之和();
        System.out.println(solution.fourSum(new int[]{1, 0, -1, 0, -2, 2, 3, -4, 5}, 0));
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
        if (tempList.size() == 2) {
            Integer fourth = map.get(sum);
            if (fourth != null) {
                ArrayList<Integer> copy = new ArrayList<>(tempList);
                copy.add(fourth);
                result.add(copy);
            }
            return;
        }
        for (int i = start; i < nums.length; i++) {
            //去重 基操
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            //剪枝
            if (nums.length - i < 3 - tempList.size()) {
                return;
            }
            //如果后面一个数*剩余的个数的和都还大了
            if (i < nums.length - 1 && sum + nums[i] + (2 - tempList.size()) * nums[i + 1] > target) {
                continue;
            }
            //如果最后的数*剩余的个数的和都还小了
            if (i < nums.length - 1 && sum + nums[i] + (2 - tempList.size()) * nums[nums.length - 1] < target) {
                continue;
            }

            tempList.add(nums[i]);
            backTrack(tempList, i + 1, sum + nums[i]);
            tempList.remove(tempList.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
