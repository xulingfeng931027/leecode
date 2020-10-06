package 回溯;//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 407 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
public class 组合 {
    private List<List<Integer>> result = new ArrayList<>();
    private int n;
    private int k;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backTrack(new LinkedList<>(), 1);
        return result;
    }

    void backTrack(LinkedList<Integer> tempList, int start) {
        if (tempList.size() == k) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i <= n; i++) {
            tempList.addLast(i);
            backTrack(tempList, i+1 );
            tempList.removeLast();
        }
    }

    public static void main(String[] args) {
        组合 solution = new 组合();
        System.out.println(solution.combine(4, 2));

    }
}
//leetcode submit region end(Prohibit modification and deletion)
