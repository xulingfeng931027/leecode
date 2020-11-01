package 回溯;//给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
//
// 返回 s 所有可能的分割方案。 
//
// 示例: 
//
// 输入: "aab"
//输出:
//[
//  ["aa","b"],
//  ["a","a","b"]
//] 
// Related Topics 回溯算法 
// 👍 388 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
public class 找出所有回文串 {
    private List<List<String>> result = new ArrayList<>();
    private String s;

    public static void main(String[] args) {
        找出所有回文串 solution = new 找出所有回文串();
        System.out.println(solution.partition("aadabc"));
    }

    public List<List<String>> partition(String s) {
        if (s.isEmpty()) {
            return result;
        }
        this.s = s;
        backTrack(new ArrayList<>(), 0);
        return result;
    }

    void backTrack(List<String> tempList, int start) {
        if (start >= s.length()) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String substring = s.substring(start , i + 1);
            if (isCycleString(substring)) {
                tempList.add(substring);
                backTrack(tempList, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }

    }

    private boolean isCycleString(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
