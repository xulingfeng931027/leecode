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
        //得到x的位数
        int zeroNum = 0;
        while (x != 0) {
            x /= 10;
            zeroNum++;
        }
        for (int i = 0; i < zeroNum / 2; i++) {
            double left = (x / Math.pow(10, i)) % 10;
            double right = (x / Math.pow(10, zeroNum - i - 1)) % 10;
            if (left != right) {
                return false;
            }
        }
        return true;

    }
//leetcode submit region end(Prohibit modification and deletion)


    @Test
    public void test() {
        int n = 1234;
//        int qian = (n / 1000) % 10;
//        int bai = (n / 100) % 10;
//        int shi = (n / 10) % 10;
//        int ge = n % 10;
//        System.out.println(qian);
//        System.out.println(bai);
//        System.out.println(shi);
//        System.out.println(ge);
        System.out.println(isPalindrome(n));
    }
}
