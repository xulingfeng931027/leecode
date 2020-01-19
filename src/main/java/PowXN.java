import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * todo 描述作用
 *
 * @author 逼哥
 * @date 1/18/2020
 */
public class PowXN {
    private Map<Integer, Double> map = new HashMap<>();

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return fastPow(x, n);
    }

    public double fastPow(double x, int n) {

        Double result = map.get(n / 2);
        if (result == null) {
            result = fastPow(x, n / 2);
            map.put(n / 2, result);
        }
        if (n % 2 == 0) {
            return result * result;
        } else {
            return result * result * x;
        }
    }

    @Test
    public void test() {
        //        System.out.println(myPow(2, 7));
        int n = -2147483648;
        System.out.println(Integer.MAX_VALUE);
    }
}
