//给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不
//是 4 次，则需要在最终答案中包含该字符 3 次。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 输入：["bella","label","roller"]
//输出：["e","l","l"]
// 
//
// 示例 2： 
//
// 输入：["cool","lock","cook"]
//输出：["c","o"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 100 
// 1 <= A[i].length <= 100 
// A[i][j] 是小写字母 
// 
// Related Topics 数组 哈希表 
// 👍 166 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.commonChars(new String[]{"bella", "label", "roller"}));

    }

    public List<String> commonChars(String[] A) {
        Map<Character, Integer> minfreq = new HashMap<>();
        for (char c : A[0].toCharArray()) {
            minfreq.put(c, minfreq.getOrDefault(c, 0) + 1);
        }
        for (String word : A) {
            Map<Character, Integer> map = new HashMap<>();
            int length = word.length();
            for (int i = 0; i < length; ++i) {
                char ch = word.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            minfreq.replaceAll((k, v) -> Math.min(map.getOrDefault(k, 0), v));
        }
        List<String> result = new ArrayList<>();
        minfreq.forEach((key, value) -> {
            for (int i = 0; i < value; i++) {
                result.add(String.valueOf(key));
            }
        });
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
