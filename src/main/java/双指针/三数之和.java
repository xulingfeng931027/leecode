package 双指针;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author XuLingfeng
 * @Description 一句话描述
 * @date 2021/1/19.10:49
 */
public class 三数之和 {

    //leetcode submit region begin(Prohibit modification and deletion)
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            //提前剪枝
            int target = nums[i];
            if (nums[i] > 0) {
                continue;
            }
            // 去重
            if (i > 0 && target == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] + target == 0) {
                    result.add(generate(nums[left], nums[right], target));
                    while (left < right && nums[right - 1] == nums[right]) {
                        right--;
                    }
                    while (left < right && nums[left + 1] == nums[left]) {
                        left++;
                    }
                    left++;
                    right--;
                } else if (nums[left] + nums[right] + target > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }

    private List<Integer> generate(int a, int b, int c) {
        List<Integer> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        return list;
    }

    @Test
    public void test() {
        System.out.println(threeSum(new int[]{0, 0, 0}));
    }
}
