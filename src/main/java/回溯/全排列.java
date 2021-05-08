package 回溯;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 计算一组不重复的数字的全排列数 n!
 *
 * @author xulingfeng
 * @description
 * @date 2020/9/2
 */
public class 全排列 {

    //结果集
    List<List<Integer>> res = new ArrayList<>();
    int result = 0;
    private int[] nums;

    @Test
    public void main() {
        System.out.println(solution(new int[]{1, 2}));
    }

    public List<List<Integer>> solution(int[] nums) {
        this.nums = nums;
        //记录路径
        List<Integer> track = new ArrayList<>();
        backTrack(track);
        return res;
    }

    // 路径：记录在 track 中
// 选择列表：nums 中不存在于 track 的那些元素
// 结束条件：nums 中的元素全都在 track 中出现
    void backTrack(List<Integer> track) {
        //触发结束条件
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
            result++;
            return;
        }
        for (int num : nums) {
            if (track.contains(num)) {
                //不能重复选择,去掉不合法路径
                continue;
            }
            //做选择
            track.add(num);
            //进入下一层
            backTrack(track);
            //回退到上一步
            track.remove(track.size() - 1);
        }
    }

}
