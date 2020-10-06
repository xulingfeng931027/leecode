package dfs.岛屿问题;//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1: 
//
// 输入:
//[
//['1','1','1','1','0'],
//['1','1','0','1','0'],
//['1','1','0','0','0'],
//['0','0','0','0','0']
//]
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//[
//['1','1','0','0','0'],
//['1','1','0','0','0'],
//['0','0','1','0','0'],
//['0','0','0','1','1']
//]
//输出: 3
//解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 792 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class 岛屿数量 {
    private int m;
    private int n;
    private char[][] grid;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }

    void dfs(int x, int y) {
        if (!inScope(x, y, m, n) || grid[x][y] != '1') {
            return;
        }
        grid[x][y] = '0';
        dfs(x + 1, y);
        dfs(x - 1, y);
        dfs(x, y + 1);
        dfs(x, y - 1);
    }

    private boolean inScope(int x, int y, int m, int n) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
