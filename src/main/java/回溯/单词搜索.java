package 回溯;//给定一个二维网格和一个单词，找出该单词是否存在于网格中。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例: 
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false 
//
// 
//
// 提示： 
//
// 
// board 和 word 中只包含大写和小写英文字母。 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 1 <= word.length <= 10^3 
// 
// Related Topics 数组 回溯算法 
// 👍 638 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class 单词搜索 {
    /**
     * 待搜索的数组
     */
    private char[][] board;
    private boolean exist = false;
    private String word;
    /**
     * 走过的路径坐标 防止走重复了
     */
    private boolean[][] marked;
    /**
     * 上下左右4个方向的坐标变动 此题中顺序不重要
     */
    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    /**
     * 目标数组横纵坐标的长度
     */
    private int m;
    private int n;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        m = board.length;
        n = board[0].length;
        this.marked = new boolean[m][n];
        for (int i = 0; i < board.length; i++) {
            char[] chars = board[i];
            for (int j = 0; j < chars.length; j++) {
                //依次从每个起点开始查找
                backTrack(i, j, 0);
                if (exist) {
                    return true;
                }
            }
        }
        return false;
    }

    void backTrack(int i, int j, int start) {
        if (exist) {
            return;
        }
        char c = board[i][j];
        if (c != word.charAt(start)) {
            //提前剪枝
            return;
        }
        if (start == word.length() - 1) {
            exist = true;
            return;
        }
        marked[i][j] = true;
        for (int[] ints : direction) {
            int newX = i + ints[0];
            int newY = j + ints[1];
            //上下左右4个方向都尝试前进
            if (inArea(newX, newY, m, n) && !marked[newX][newY]) {
                backTrack(newX, newY, start + 1);
            }
        }
        marked[i][j] = false;
    }

    /**
     * 判断当前坐标是否在数组范围内
     */
    private boolean inArea(int x, int y, int m, int n) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }

    public static void main(String[] args) {
//        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        char[][] board = new char[][]{{'A', 'B', 'C'}, {'S', 'F', 'C',}, {'A', 'D', 'E'}};
        char[][] board = new char[][]{{'A'}};

        单词搜索 test = new 单词搜索();
        System.out.println(test.exist(board, "B"));

    }
}
//leetcode submit region end(Prohibit modification and deletion)
