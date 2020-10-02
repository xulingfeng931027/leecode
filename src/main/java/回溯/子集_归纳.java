package 回溯;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 给定�?组不含重复元素的整数数组 nums，返回该数组�?有可能的子集（幂集）�?
//
// 说明：解集不能包含重复的子集�?
//
// 示例:
//
// 输入: nums = [1,2,3]
// 输出:
// [
//  [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]
// Related Topics 位运算 数组 回溯算法
public class 子集_归纳 {


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            List<Integer> list = new ArrayList<>();
            result.add(list);
            return result;
        }
        //先把最后一个数拿出来
        int last = nums[nums.length - 1];
        nums = Arrays.copyOf(nums, nums.length - 1);

        result = subsets(nums);
        int size = result.size();

        for (int i = 0; i < size; i++) {
            List<Integer> newList = new ArrayList<>(result.get(i));
            newList.add(last);
            result.add(newList);
        }
        return result;
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = subsets(nums);
        System.out.println(result);
    }
}
