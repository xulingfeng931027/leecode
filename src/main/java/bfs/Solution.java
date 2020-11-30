package bfs;//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回 0。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。 
// Related Topics 广度优先搜索 
// 👍 558 👎 0


import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(beginWord);
        visited.add(beginWord);
        int count = 1;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                String poll = queue.poll();
                ;
                for (String s : wordList) {
                    //满足条件
                    if (!visited.contains(s) && helper(poll, s)) {
                        if (s.equals(endWord)) {
                            System.out.println(s);
                            return count + 1;
                        }
                        System.out.println(s);
                        queue.add(s);
                        visited.add(s);
                    }
                }
            }
            count++;
        }
        return 0;
    }

    private boolean helper(String a, String b) {
        //判断两个字符串有且只有一个字符不相同
        int count = 0;
        int n = a.length();
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }

    @Test
    public void test() {
        System.out.println(ladderLength("leet", "code",
                Lists.newArrayList("lest", "leet", "lose", "code", "lode", "robe", "lost")));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
