package dfs;//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
// 示例:
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//
//
// 说明:
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
// Related Topics 字符串 回溯算法
// 👍 909 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class 电话号码的字母组合 {
    private String digits;
    private List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if ("".equals(digits)) {
            return result;
        }
        this.digits = digits;
        backTrack(0, new StringBuilder());
        return result;
    }

    private void backTrack(int index, StringBuilder temp) {
        //退出条件是字符串长度等于输入的长度
        if (index == digits.length()) {
            result.add(temp.toString());
            return;
        }
        char number = digits.charAt(index);
        String choices = translate(number);
        for (int i = 0; i < choices.toCharArray().length; i++) {
            temp.append(choices.charAt(i));
            backTrack(index + 1, temp);
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    private String translate(char number) {
        switch (number) {
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        电话号码的字母组合 test = new 电话号码的字母组合();
        System.out.println(test.letterCombinations("25354576797857"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
