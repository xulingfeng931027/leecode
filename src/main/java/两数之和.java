import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * todo 描述作用
 *
 * @author 逼哥
 * @date 2020/1/6
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * // 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * //
 * // 示例:
 * //
 * // 给定 nums = [2, 7, 11, 15], target = 9
 * //
 * //因为 nums[0] + nums[1] = 2 + 7 = 9
 * //所以返回 [0, 1]
 * //
 * // Related Topics 数组 哈希表
 */
public class 两数之和 {


    //leetcode submit region begin(Prohibit modification and deletion)
    public int[] twoSum(int[] nums, int target) {
        return getInts1(nums, target);
    }

    private int[] getInts0(int[] nums, int target) {
        int[] arr = new int[2];
        //双重循环 遍历之
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
        }
        return null;
    }

    private int[] getInts1(int[] nums, int target) {
        int[] arr = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            Integer x = map.get(target - nums[i]);
            if (x != null) {
                arr[0] = i;
                arr[1] = x;
                return arr;
            }
        }
        return arr;
    }

    @Test
    public void test() {
        int[] arr = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(arr, 9)));
    }
}



