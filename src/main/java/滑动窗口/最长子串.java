package 滑动窗口;//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4515 👎 0


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
public class 最长子串 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int n = s.length();
        int result = 0;
        StringBuilder builder = new StringBuilder();
        while (right < n) {
            char c1 = s.charAt(right);
            right++;
            System.out.println("右侧指针前进后"+builder.append(c1));
            map.put(c1, map.getOrDefault(c1, 0) + 1);
            while (map.get(c1) > 1) {
                char c2 = s.charAt(left);
                System.out.println("左侧指针前进后"+builder.deleteCharAt(0));
                map.compute(c2, (k, v) -> v <= 1 ? null : v - 1);
                left++;
            }
            result = Math.max(result, right - left);

        }
        return result;
    }

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring("abbde"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
