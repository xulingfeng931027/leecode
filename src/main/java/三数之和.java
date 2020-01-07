import org.junit.Test;

import java.util.*;

/**
 * todo 描述作用
 *
 * @author 徐凌峰
 * @date 2020/1/7
 */
public class 三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        return solution2(nums);
    }

    public List<List<Integer>> solution1(int[] nums) {
        // 暴力解法,三重循环 前面两层遍历元素,最后一层遍历和
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        //通过排序来去重
                        Collections.sort(list);
                        if (!result.contains(list)) {
                            result.add(list);
                        }
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
        // 双指针hash表
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

        -6,1,2,3,4,3,9
    }

    @Test
    public void test() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution2(nums));
    }
}
