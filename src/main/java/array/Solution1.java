package array;

import org.junit.Test;

/**
 * @author 逼哥
 * @date 2019/12/29 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>示例 1:
 * <p>给定数组 nums = [1,1,2],
 * <p>函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * <p>你不需要考虑数组中超出新长度后面的元素。 示例 2:
 * <p>给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * <p>函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * <p>你不需要考虑数组中超出新长度后面的元素。
 */
public class Solution1 {
    public int removeDuplicates(int[] nums) {
        int duplicateNums = 0;
        int temp = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            int left = temp;
            int right = nums[i + 1];
            if (left == right) {
                duplicateNums++;
                if (i + 2 < nums.length) {
                    nums[i + 1] = nums[i + 2];
                }
            }
        }
        return nums.length - duplicateNums;
    }

    @Test
    public void test() {
        int[] nums = {1, 1, 2, 3, 4, 4};
        System.out.println(removeDuplicates(nums));
    }
}
