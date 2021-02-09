package 滑动窗口;//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的子串。 
//
// 示例1: 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 
//
// 示例2: 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 注意： 
//
// 
// 输入的字符串只包含小写字母 
// 两个字符串的长度都在 [1, 10,000] 之间 
// 
// Related Topics 双指针 Sliding Window 
// 👍 221 👎 0


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
public class 判断是否是子串 {
    public boolean checkInclusion(String s1, String s2) {
        char[] chars = s2.toCharArray();
        int left = 0;
        int right = 0;
        Map<Character, Integer> need = new HashMap<>();
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> window = new HashMap<>();
        int valid = 0;
        while (right < s2.length()) {
            char c = chars[right];
            right++;

            if (need.get(c) != null) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            //只要窗口大于子串长度 就开始尝试收缩
            while (right - left == s1.length()) {
                // 在这里判断是否找到了合法的子串
                if (valid == need.size()) {
                    return true;
                }
                char d = chars[left];
                left++;
                // 进行窗口内数据的一系列更新
                if (need.get(d) != null) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return false;
    }

    @Test
    public void testWithError() {
        System.out.println(checkInclusion("ab", "eidbaooo"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
