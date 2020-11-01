//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
// 示例 1：
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
//
//
// 示例 2：
//
// 输入: "cbbd"
//输出: "bb"
//
// Related Topics 字符串 动态规划
// 👍 2850 👎 0


import org.junit.Test;

//leetcode submit region begin(Prohibit modification and deletion)
public class 最长回文子串 {
    public String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i + 1);
            // 返回以 s[l] 和 s[r] 为中心的最长回文串
            result = result.length() < s1.length() ? s1 : result;
            result = result.length() < s2.length() ? s2 : result;
        }
        return result;
    }

    private String palindrome(String s, int l, int r) {
        // 防止索引越界
        while (l >= 0 && r <= s.length()-1 && s.charAt(l) == s.charAt(r)) {
            // 向两边展开
            l--;
            r++;
        }
        // 返回以 s[l] 和 s[r] 为中心的最长回文串
        return s.substring(l + 1, r);
    }

    @Test
    public void test() {
        System.out.println(longestPalindrome("babad"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)


