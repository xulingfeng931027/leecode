package 滑动窗口;//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
//
// 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 902 👎 0


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
public class 最小覆盖子串 {
    public String minWQindow(String s, String t) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int start = 0;
        int end = Integer.MAX_VALUE;
        int valid = 0;
        char[] chars = s.toCharArray();
        while (right < chars.length) {
            char c = chars[right];
            right++;
            if (need.get(c) != null) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
                System.out.println("右移" + left + "..." + right);
            }
            while (valid == need.size()) {
                start = left;
                end = right;
                char b = chars[left];
                left++;

                if (need.get(b) != null) {
                    if (need.get(b).equals(window.get(b))) {
                        valid--;
                    }
                    System.out.println("左移" + left + "..." + right);
                    window.put(b, window.get(b) - 1);
                }
            }
        }
        return end == Integer.MAX_VALUE ? "" : s.substring(start, end);
    }

    @Test
    public void testWithError() {
        System.out.println(minWQindow("AODCBBEBANC",
                "ABC"));

    }
}
//leetcode submit region end(Prohibit modification and deletion)
