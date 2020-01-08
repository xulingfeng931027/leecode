import org.junit.Test;

import java.util.*;
// 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三
// 元组。
//
// 注意：答案中不可以包含重复的三元组。
//
// 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
// 满足要求的三元组集合为：
// [
//  [-1, 0, 1],
//  [-1, -1, 2]
// ]
//
// Related Topics 数组 双指针

/**
 * todo 描述作用
 *
 * @author 徐凌峰
 * @date 2020/1/7
 */
public class 三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        return solution3(nums);
    }

    public List<List<Integer>> solution1(int[] nums) {
        // 暴力解法,三重循环 前面两层遍历元素,最后一层遍历和
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        addListToResult(result, nums[i], nums[j], nums[k]);
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> solution2(int[] nums) {
        // 双重循环 带hash表
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(-nums[i], i);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int target = nums[i] + nums[j];
                Integer zeroKey = map.get(target);
                if (zeroKey != null && zeroKey != i && zeroKey != j) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[zeroKey]);
                    //通过排序来去重
                    Collections.sort(list);
                    if (!result.contains(list)) {
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> solution3(int[] nums) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < length - 1; i++) {
            int target = -nums[i];
            if (target < 0) {
                break;
            }
            if (i > 0 && nums[i - 1] == nums[i]) {
                // 去重  防止两个target相同导致重复
                continue;
            }
            int lIndex = i + 1;
            int rIndex = length - 1;
            while (rIndex > lIndex) {
                int left = nums[lIndex];
                int right = nums[rIndex];
                if (left + right == target && i != lIndex && i != rIndex) {
                    addListToResult(result, nums[i], left, right);
                    while (lIndex < rIndex && nums[lIndex] == nums[lIndex + 1]) {
                        //去重
                        lIndex++;
                    }
                    while (lIndex < rIndex && nums[rIndex] == nums[rIndex - 1]) {
                        rIndex--;
                    }
                    //找到后挪动两个指针  找下一对
                    lIndex++;
                    rIndex--;
                } else if (left + right > target) {
                    rIndex--;
                } else if (left + right < target) {
                    lIndex++;
                }
            }
        }
        return result;
    }

    private void addListToResult(List<List<Integer>> result, int num, int num1, int num2) {
        List<Integer> list = new ArrayList<>();
        list.add(num);
        list.add(num1);
        list.add(num2);
        result.add(list);
    }


    @Test
    public void test() {
        int[] nums = {-2, 0, 1, 1, 2};
        System.out.println(solution3(nums));
    }
}
