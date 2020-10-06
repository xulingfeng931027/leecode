package 回溯;//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法 
// 👍 413 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
public class 组合总和2 {
    private List<List<Integer>> result = new ArrayList<>();
    private int[] candidates;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        this.candidates = candidates;
        backTrack(new ArrayList<>(), 0, target);
        return result;
    }

    void backTrack(List<Integer> way, int start, int amount) {
        if (amount == 0) {
            result.add(new ArrayList<>(way));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                System.out.println("当前i=" + i);
                continue;
            }
            if (amount - candidates[i] < 0) {
                break;
            }
            way.add(candidates[i]);
            backTrack(way, i + 1, amount - candidates[i]);
            way.remove(way.size() - 1);
        }
    }

    public static void main(String[] args) {
        组合总和2 solution = new 组合总和2();
        System.out.println(solution.combinationSum2(new int[]{1, 1, 2, 3}, 5));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
