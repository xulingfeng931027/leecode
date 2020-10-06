package 回溯;
//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯算法 
// 👍 973 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
public class 组合总和 {
    private List<List<Integer>> result = new ArrayList<>();
    private int[] candidates;
    private int target;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        if (candidates.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.target = target;
        backTrack(new ArrayList<>(), 0, 0);
        return result;
    }

    void backTrack(List<Integer> tempList, int start, int sum) {
        if (sum == target) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                return;
            }
            tempList.add(candidates[i]);
            System.out.println("递归之前" + "list=" + tempList + ",i=" + i);
            backTrack(tempList, i, sum + candidates[i]);
            tempList.remove(tempList.size() - 1);
            System.out.println("递归之后" + "list=" + tempList + ",当前和sum=" + sum + ",i=" + i);
        }
    }

    public static void main(String[] args) {
        组合总和 solution = new 组合总和();
        System.out.println(solution.combinationSum(new int[]{3, 2, 7, 6}, 7));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
