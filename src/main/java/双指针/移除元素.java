package 双指针;

import org.junit.Test;

/**
 * @author XuLingfeng
 * @Description 一句话描述
 * @date 2021/1/19.16:35
 */
public class 移除元素 {

    public int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        int n = nums.length;
        while (fast < n) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow + 1;
    }

    @Test
    public void test() {
        removeElement(new int[]{2, 3, 2, 2, 1}, 2);
    }
}
