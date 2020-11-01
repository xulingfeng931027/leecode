package 回溯;

/**
 * @author Xulingfeng
 * @description 给你⼀个 N×N 的棋盘，让你放置 N 个
 * 皇后，使得它们不能互相攻击。
 * PS：皇后可以攻击同⼀⾏、同⼀列、左上左下右上右下四个⽅向的任意单位。
 * 求有几种放置的方法
 * @date 2020/9/4
 */
public class N皇后 {

    private int result;
    private int n;
    private int[][] board;

    public static void main(String[] args) {
        System.out.println(new N皇后().totalNQueens(4));
//        System.out.println("循环次数为"+times);
    }

    public int totalNQueens(int n) {
        this.n = n;
        this.board = new int[n][n];
        backTrack(0, 0);
        return result;
    }

    private void backTrack(int row, int queens) {
        if (queens == n) {
            result++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (!isLegal(row, col)) {
                continue;
            }
            board[row][col] = 1;
            backTrack(row + 1, queens + 1);
            board[row][col] = 0;
        }
    }

    private boolean isLegal(int row, int col) {
        //由于行是往下走的 这里只需要检测列数据即可
        for (int i = 0; i < n; i++) {
            //检查列是否冲突
            if (board[i][col] == 1) {
                return false;
            }
        }
        for(int i=row-1, j=col-1;i>=0&&j>=0;i--,j--){
            if(board[i][j]==1){
                return false;
            }
        }

        // 检查右上⽅是否有皇后互相冲突
//        for (int i = row - 1, j = col + 1;
//             i >= 0 && j < n; i--, j++) {
//            if (board[i][j] == 1) {
//                return false;
//            }
//        }
        int i = row;
        int j = col;
        //右上
        while (i >= 1 && j < n - 1) {
            if (board[--i][++j] == 1) {
                return false;
            }
        }
        //左上
        i = row;
        j = col;
        while (i >= 1 && j >= 1) {
            if (board[--i][--j] == 1) {
                return false;
            }
        }
        // 检查左上⽅是否有皇后互相冲突
//        for (int i = row - 1, j = col - 1;
//             i >= 0 && j >= 0; i--, j--) {
//            if (board[i][j] == 1) {
//                return false;
//            }
//        }
        return true;
    }

}
