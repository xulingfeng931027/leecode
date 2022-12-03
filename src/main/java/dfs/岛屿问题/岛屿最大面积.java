package dfs.岛屿问题;

public class 岛屿最大面积 {
    private int max = 0;
    private int result = 0;

    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][i] == 1) {
                    result = 0;
                    dfs(grid, i, j);
                    max = Integer.max(result, max);
                }
            }
        }
        return max;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            //超出索引
            return;
        }
        if (grid[i][j] == 0) {
            return;
        }
        //四个方向继续搜索陆地
        grid[i][j] = 0;
        result++;
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
