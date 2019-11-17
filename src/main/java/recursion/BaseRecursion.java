package recursion;

/**
 * @author 逼哥
 * @date 2019/9/14 以相反的顺序打印字符串。用递归实现
 */
public class BaseRecursion {

    public static void main(String[] args) {
        System.out.println(helper("abc"));
    }

    private static String helper(String str) {
        //退出条件是参数串的长度小于等于1
        if (str.length() <= 1) {
            return str;
        }
        //将字符串分为  a 和bcde   再分为b 和cde 最后倒着返回.
        String result = helper(str.substring(1)) + str.charAt(0);
        System.out.println(result);
        return result;
    }
}
