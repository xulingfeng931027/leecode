package 回溯;

import java.util.*;

/**
 * 计算一组不重复的数字的全排列数 n!
 *
 * @author xulingfeng
 * @description
 * @date 2020/9/2
 */
public class 全排列2号 {


    Map<Integer, Integer> tempMap = new HashMap<>();
    private List<List<Integer>> result = new ArrayList<>();
    private int[] nums;

    public static void main(String[] args) {
        全排列2号 test = new 全排列2号();
        System.out.println(test.solution(new int[]{1, 1, 2}));
//        System.out.println(全排列.res);
//        System.out.println(test.solution2(4));

    }

    public List<List<Integer>> solution(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        backTrack(new ArrayList<>(), new int[nums.length]);
        return result;
    }

    void backTrack(List<Integer> track, int[] use) {
        if (track.size() == nums.length) {
            result.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (use[i] == 1) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && use[i - 1] == 0) {
                continue;
            }
            track.add(nums[i]);
            use[i] = 1;
            backTrack(track, use);
            track.remove(track.size() - 1);
            use[i] = 0;
        }
    }
}