import org.junit.Test;

/**
 * todo 描述作用
 *
 * @author 逼哥
 * @date 2020/1/6
 */
public class 盛水最多的容器 {
    //给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i,
//ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
// 说明：你不能倾斜容器，且 n 的值至少为 2。
//
//
//
// 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
//
//
//
// 示例:
//
// 输入: [1,8,6,2,5,4,8,3,7]
//输出: 49
// Related Topics 数组 双指针


    //leetcode submit region begin(Prohibit modification and deletion)
    public int maxArea(int[] height) {
        int maxArea = 0;
        int i = 0;
        int j = height.length - 1;
        while (j > i) {
            int left = height[i];
            int right = height[j];
            int area = calculateArea(i, j, left, right);
            maxArea = Math.max(maxArea, area);
            if (left <= right) {
                i++;
            }else {
                j--;
            }
        }
        return maxArea;
    }

    private int calculateArea(int i, int j, int left, int right) {
        return (j - i) * Math.min(left, right);
    }

    @Test
    public void test() {
        int[] height = {2, 5, 6, 1, 8, 4, 9};
        System.out.println(maxArea(height));

    }


//leetcode submit region end(Prohibit modification and deletion)

}
