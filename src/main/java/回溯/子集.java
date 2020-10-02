package 回溯;

import org.junit.Test;

import java.util.ArrayList;
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
public class 子集 {

    int[] nums;
    List<List<Integer>> result = new ArrayList<>();

    public void subsets(int[] nums) {
        this.nums = nums;
        if (nums.length == 0) {
            return;
        }

        process(new ArrayList<>(), 0);
    }

    private void process(List<Integer> list, int index) {
        result.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            //选择第index个元素
            process(list, i + 1);
            list.remove(list.size() - 1);
        }

    }

    @Test
    public void test() {
        int[] nums = new int[18];
        subsets(nums);
        System.out.println(result);
        System.out.println(result.size());
    }
}
