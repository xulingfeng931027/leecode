package 滑动窗口;//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
//
// 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
//
// 说明：
//
//
// 字母异位词指字母相同，但排列不同的字符串。
// 不考虑答案输出的顺序。
//
//
// 示例 1:
//
//
//输入:
//s: "cbaebabacd" p: "abc"
//
//输出:
//[0, 6]
//
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
//
//
// 示例 2:
//
//
//输入:
//s: "abab" p: "ab"
//
//输出:
//[0, 1, 2]
//
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
//
// Related Topics 哈希表
// 👍 395 👎 0


import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
public class 异位词 {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> needs = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> windows = new HashMap<>();
        //左闭右开
        int left = 0;
        int right = 0;
        int match = 0;
        int n = s.length();
        List<Integer> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        while (right < n) {
            //获取右侧字符
            char rightChar = s.charAt(right);
            System.out.println("右侧指针前进后"+builder.append(rightChar));
            //用右侧字符填充窗口
            if (needs.containsKey(rightChar)) {
                windows.put(rightChar, windows.getOrDefault(rightChar, 0) + 1);
                if (windows.get(rightChar).equals(needs.get(rightChar))) {
                    match++;
                }
            }
            right++;
            //如果当前窗口满足条件
            while (match == needs.size()) {
                //获取左侧字符
                char leftChar = s.charAt(left);
                System.out.println("左侧指针前进后"+builder.deleteCharAt(0));
                if (right - left == p.length()) {
                    result.add(left);
                }
                //移除左侧字符
                if (needs.containsKey(leftChar)) {
                    windows.put(leftChar, windows.getOrDefault(leftChar, 0) - 1);
                    if (windows.get(leftChar) < needs.get(leftChar)) {
                        match--;
                    }
                }
                left++;
            }
        }
        return result;
    }


    @Test
    public void test() {
        异位词 solution = new 异位词();
        System.out.println(solution.findAnagrams("abcdebbaba", "ab"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
