import org.junit.Test;

/**
 *
 * @author 徐凌峰
 * @date 2020/1/8
 */
public class 最长公共前缀 {
    //编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
// 示例 1:
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
//
//
// 示例 2:
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
//
//
// 说明:
//
// 所有输入只包含小写字母 a-z 。
// Related Topics 字符串

    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 0; i < prefix.length(); i++) {
            String childStr = prefix.substring(0, i + 1);
            boolean flag = true;
            for (String str : strs) {
                if (!str.startsWith(childStr)) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                return prefix.substring(0, i);
            }
        }
        return prefix;
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }

            }
        }

        return prefix;
    }


    @Test
    public void test() {
        String[] strs = {"dog","racecar","car"};
//        String[] strs = {"d"};
//        String[] strs = {  "flower","flow","flight"};
//        String[] strs = {  };
        System.out.println(longestCommonPrefix1(strs));
    }
}
