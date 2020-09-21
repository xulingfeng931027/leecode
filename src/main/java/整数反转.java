import org.junit.Test;

/**
 * @author 逼哥
 * @date 1/27/2020
 */
public class 整数反转 {

    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;

            x /= 10;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    @Test
    public void test() {
        System.out.println(reverse(123445));
    }
}
