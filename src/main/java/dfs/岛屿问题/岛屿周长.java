package dfs.岛屿问题;//给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
//
// 网格中的格子水平和垂直方向相连（对角线方向不相连）。
// 整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
//
// 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。
// 格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿
//的周长。
//
//
//
// 示例 :
//
// 输入:
//[[0,1,0,0],
// [1,1,1,0],
// [0,1,0,0],
// [1,1,0,0]]
//
//输出: 16
//
//解释: 它的周长是下面图片中的 16 个黄色的边：
//
//
//
// Related Topics 哈希表
// 👍 296 👎 0


import org.junit.Test;

//leetcode submit region begin(Prohibit modification and deletion)
public class 岛屿周长 {
    private int length;
    private int width;

    public int islandPerimeter(int[][] grid) {
        width = grid.length;
        length = grid[0].length;
        int result = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                if (grid[i][j] == 1) {
                    int temp = helper(grid, i, j);
                    result += temp;
                    System.out.println("i=" + i + "j=" + j + "周长=" + temp);
                }
            }
        }
        return result;
    }

    private int helper(int[][] grid, int row, int col) {
        int tempLength = 0;
        if (row - 1 < 0 || grid[row - 1][col] == 0) {
            tempLength++;
        }
        if (row + 1 >= width || grid[row + 1][col] == 0) {
            tempLength++;
        }
        if (col - 1 < 0 || grid[row][col - 1] == 0) {
            tempLength++;
        }
        if (col + 1 >= length || grid[row][col + 1] == 0) {
            tempLength++;
        }
        return tempLength;
    }

    @Test
    public void test() {
        islandPerimeter(new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}});

    }
}
//leetcode submit region end(Prohibit modification and deletion)
