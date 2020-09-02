package LeetCode;

/**
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * =============================================
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * =============================================
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 * =============================================
 * 此外，你可以假设该网格的四条边均被水包围。
 * =============================================
 *  
 * =============================================
 * 示例 1:
 * =============================================
 * 输入:
 * [
 * ['1','1','1','1','0'],
 * ['1','1','0','1','0'],
 * ['1','1','0','0','0'],
 * ['0','0','0','0','0']
 * ]
 * 输出: 1
 * 示例 2:
 * =============================================
 * 输入:
 * [
 * ['1','1','0','0','0'],
 * ['1','1','0','0','0'],
 * ['0','0','1','0','0'],
 * ['0','0','0','1','1']
 * ]
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 */
public class LeetCode_200_Number_of_Islands {
    static class Solution {
        int[][] opt = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
        static boolean[][] visited;
        static int m, n;

        public int numIslands(char[][] grid) {
            int res = 0;
            m = grid.length;
            if (m == 0) return 0;
            n = grid[0].length;
            visited = new boolean[m][n];
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    if (grid[i][j] == '1' && !visited[i][j]) {
                        res++;
                        dfs(grid, i, j);
                    }
            return res;
        }

        private void dfs(char[][] grid, int x, int y) {
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int newX = x + opt[i][0];
                int newY = y + opt[i][1];
                if (inArea(newX, newY) && !visited[newX][newY] && grid[newX][newY] == '1')
                    dfs(grid, newX, newY);
            }
        }

        private boolean inArea(int x, int y) {
            return x >= 0 && y >= 0 && x < m && y < n;
        }
    }

    public static void main(String[] args) {
        char[][] board =
                {
                        {'1', '1', '1', '1', '0'},
                        {'1', '1', '0', '1', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '0', '0', '0'}
                };
        char[][] board2 =
                {
                        {'1', '1', '0', '0', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '1', '0', '0'},
                        {'0', '0', '0', '1', '1'}
                };
//        int res = new Solution().numIslands(board);
        int res2 = new Solution().numIslands(board2);
//        System.out.println(res);
        System.out.println(res2);
    }
}
//class Solution:
//    def numIslands(self, grid: List[List[str]]) -> int:
//
//        m = len(grid)
//        if not m: return 0
//        n = len(grid[0])
//        opt = [(0, -1), (1, 0), (0, 1), (-1, 0)]
//        visited = [[False for _ in range(n)] for _ in range(m)]
//        res = 0
//
//        def dfs(x, y) -> None:
//            visited[x][y] = True
//            for d in opt:
//                nx, ny = x + d[0], y + d[1]
//                if -1 < nx < m and -1 < ny < n and not visited[nx][ny] and grid[nx][ny] == "1":
//                    dfs(nx, ny)
//
//        for i in range(m):
//            for j in range(n):
//                if grid[i][j] == "1" and not visited[i][j]:
//                    res += 1
//                    dfs(i, j)
//        return res
//