package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xulingfeng
 * @description 给你⼀个 N×N 的棋盘，让你放置 N 个
 * 皇后，使得它们不能互相攻击。
 * PS：皇后可以攻击同⼀⾏、同⼀列、左上左下右上右下四个⽅向的任意单位。
 * 求有几种放置的方法
 * @date 2020/9/4
 */
public class N皇后 {

    private List<int[][]> result = new ArrayList<>();
    private static long times = 0;

    public int solution(int n) {
        int[][] data = new int[n][n];
        backTrack(data, 0);
        return result.size();
    }

    private void backTrack(int[][] data, int row) {
        if (row == data.length) {
            result.add(data);
            return;
        }
        for (int col = 0; col < data.length; col++) {
            times++;
            if (!isValid(data, col, row)) {
                continue;
            }
            data[row][col] = 1;
            backTrack(data, row + 1);
            data[row][col] = 0;
        }
    }

    private boolean isValid(int[][] data, int col, int row) {
        int n = data.length;
        // 检查列是否有皇后互相冲突
        for (int[] cols : data) {
            times++;
            if (cols[col] == 1)
                return false;
        }
// 检查右上⽅是否有皇后互相冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            times++;
            if (data[i][j] == 1)
                return false;
        }
// 检查左上⽅是否有皇后互相冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            times++;
            if (data[i][j] == 1)
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        Character c = '2';
//        System.out.println(new N皇后().solution(8));
//        System.out.println("循环次数为"+times);
    }

}
