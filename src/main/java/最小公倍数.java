/**
 * @author 徐凌峰
 * @date 2020/7/4
 */
public class 最小公倍数 {

    public static int test(int m, int n) {
        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }
        int k;
        while (n != 0) {
            k = m % n;
            m = n;
            n = k;
        }
        return m;
    }

    public static void main(String[] args) {
        System.out.println(10 * 15 / test(10, 15));
    }
}
