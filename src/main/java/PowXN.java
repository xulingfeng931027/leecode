import org.junit.Test;

/**
 * todo 描述作用
 *
 * @author 逼哥
 * @date 1/18/2020
 */
public class PowXN {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == -1) {
            return 1 / x;
        }
        if (n == 1) {
            return x;
        }
        double result = myPow(x, n / 2);
        if (n % 2 == 0) {
            result *= result;
        } else {
            result *= result * x;
        }
        return result;
    }


    @Test
    public void test() {
        //        System.out.println(myPow(2, 7));
        int n = -2147483648;
        System.out.println(myPow(2, n));
    }
}
