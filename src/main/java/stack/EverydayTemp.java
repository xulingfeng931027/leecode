package stack;

import java.util.Arrays;

/**
 * todo 描述作用
 *
 * @author 逼哥
 * @date 2019/9/13 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 * <p>例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，
 * 你的输出应该是 [1, 1, 4, 2, 1, 1, 0,0]。
 * <p>提示：气温 列表长度的范围是 [1, 30000]。
 * 每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 */
public class EverydayTemp {

    public int[] dailyTemperatures(int[] T) {
        //双重for循环  实现慢
        if (T.length == 1) {
            return new int[] {0};
        }
        int[] result = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            for (int j = i + 1; j < T.length - 1; j++) {
                if (T[j] > T[i]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }

    public static int[] dailyTemperatures2(int[] T) {
        int length = T.length;
        int[] result = new int[length];

        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j += result[j]) {
                if (T[j] > T[i]) {
                    result[i] = j - i;
                    break;
                } else if (result[j] == 0) {
                    result[i] = 0;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] T = new int[] {22, 33, 11, 66, 55, 88, 77, 99, 111, 1, 4};
        System.out.println(Arrays.toString(dailyTemperatures2(T)));
    }
}
