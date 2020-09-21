import org.junit.Test;

/**
 * todo 描述作用
 *
 * @author 徐凌峰
 * @date 2020/1/19
 */
public class 回文数 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        // 得到x的位数
        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) {
                return false;
            }
            x = (x % div) / 10;
            div /= 100;
        }
        return true;

    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void test() {
        int n = 1;
//        int qian = (n / 1000) % 10;
//        int bai = (n / 100) % 10;
//        int shi = (n / 10) % 10;
//        int ge = n % 10;
//        System.out.println(qian);
//        System.out.println(bai);
//        System.out.println(shi);
//        System.out.println(ge);
        System.out.println(isPalindrome(123321));
    }
}
