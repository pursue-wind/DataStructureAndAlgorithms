package LeetCode;

import java.util.HashMap;

/**
 * 链接：https://leetcode-cn.com/problems/word-search
 * =================================================
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * =================================================
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * =================================================
 *  
 * =================================================
 * 示例:
 * =================================================
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * =================================================
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 * =================================================
 */
public class LeetCode_79_Word_Search {
    static class Solution {
        static int m, n;
        boolean[][] visited;
        int[][] p = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

        public boolean exist(char[][] board, String word) {
            m = board.length - 1;
            n = board[0].length - 1;
            HashMap<Character, Integer> map = new HashMap<Character, Integer>(word.length());
            for (int i = 0; i < word.length(); i++) {
                if (map.containsKey(word.charAt(i))) {
                    map.merge(word.charAt(i), 1, Integer::sum);
                } else {
                    map.put(word.charAt(i), 1);
                }
            }
            for (int i = 0; i <= m; i++)
                for (int j = 0; j <= n; j++)
                    if (map.get(board[i][j]) != null)
                        map.merge(board[i][j], -1, Integer::sum);

            for (char c : map.keySet()) {
                if (map.get(c) > 0) {
                    return false;
                }
            }

            visited = new boolean[m + 1][n + 1];
            for (int i = 0; i <= m; i++)
                for (int j = 0; j <= n; j++)
                    if (wordSearch(board, word, 0, i, j))
                        return true;
            return false;
        }

        private boolean wordSearch(char[][] board, String word, int index, int x, int y) {
            if (word.length() - 1 == index)
                return word.charAt(index) == board[x][y];

            if (word.charAt(index) == board[x][y]) {
                visited[x][y] = true;
                for (int i = 0; i < 4; i++) {
                    int newX = x + p[i][0];
                    int newY = y + p[i][1];
                    if (inArea(newX, newY) && !visited[newX][newY] && wordSearch(board, word, index + 1, newX, newY))
                        return true;
                }
                visited[x][y] = false;
            }
            return false;
        }

        private boolean inArea(int x, int y) {
            return x >= 0 && y >= 0 && x <= m && y <= n;
        }
    }

    public static void main(String[] args) {
        char[][] board =
                {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                };
        boolean abcced = new Solution().exist(board, "SEE");
        System.out.println(abcced);
    }
}
//from typing import List
//
//
//class Solution:
//    opt = [(0, -1), (1, 0), (0, 1), (-1, 0)]
//
//    def exist(self, board: List[List[str]], word: str) -> bool:
//        m = len(board)
//        if m == 0:
//            return False
//        n = len(board[0])
//
//        visited = [[False for _ in range(n)] for _ in range(m)]
//
//        for i in range(m):
//            for j in range(n):
//                if self.word_search(board, visited, word, 0, i, j):
//                    return True
//        return False
//
//    def word_search(self, board, visited, word, index, x, y) -> bool:
//        def in_area(m, n) -> bool:
//            return 0 <= m < len(board) and 0 <= n < len(board[0])
//
//        # 如果是最后一个元素
//        if len(word) - 1 == index:
//            return word[index] == board[x][y]
//        # 如果当前元素匹配
//        if word[index] == board[x][y]:
//            visited[x][y] = True
//            for op in self.opt:
//                n_x = x + op[0]
//                n_y = y + op[1]
//                if in_area(n_x, n_y) and not visited[n_x][n_y] \
//                        and self.word_search(board, visited, word, index + 1, n_x, n_y):
//                    return True
//            visited[x][y] = False
//        return False
//
//
//class Solution3:
//    def __init__(self):
//        self.visited = set()
//
//    opt = [(0, -1), (1, 0), (0, 1), (-1, 0)]
//
//    def exist(self, board: List[List[str]], word: str) -> bool:
//        m, n = len(board), len(board[0])
//
//        for i in range(m):
//            for j in range(n):
//                if self.word_search(board, word, 0, i, j):
//                    return True
//        return False
//
//    def word_search(self, board, word, index, x, y) -> bool:
//        def in_area(m, n) -> bool:
//            return 0 <= m < len(board) and 0 <= n < len(board[0])
//
//        # 如果是最后一个元素
//        if len(word) - 1 == index:
//            return word[index] == board[x][y]
//        # 如果当前元素匹配
//        if word[index] == board[x][y]:
//            self.visited.add((x, y))
//            for a, b in self.opt:
//                n_x, n_y = x + a, y + b
//                if in_area(n_x, n_y) and (n_x, n_y) not in self.visited and self.word_search(board, word, index + 1,
//                                                                                             n_x, n_y):
//                    return True
//            self.visited.remove((x, y))
//        return False
//
//class Solution4:
//    opt = [(0, -1), (1, 0), (0, 1), (-1, 0)]
//
//    def exist(self, board: List[List[str]], word: str) -> bool:
//        m, n = len(board), len(board[0])
//        need = dict()
//        for x in word:
//            need[x] = word.count(x)
//
//        for i in range(m):
//            for j in range(n):
//                if board[i][j] in need: need[board[i][j]] -= 1
//
//        if any(map(lambda x: x > 0, need.values())):
//            return False
//
//        def word_search(index, x, y) -> bool:
//            def in_area(m, n) -> bool:
//                return 0 <= m < len(board) and 0 <= n < len(board[0])
//
//            # 如果是最后一个元素
//            if len(word) - 1 == index: return word[index] == board[x][y]
//            # 如果当前元素匹配
//            if word[index] == board[x][y]:
//                visited[x][y] = True
//                for a, b in self.opt:
//                    n_x, n_y = x + a, y + b
//                    if in_area(n_x, n_y) and not visited[n_x][n_y] and word_search(index + 1, n_x, n_y):
//                        return True
//                visited[x][y] = False
//            return False
//
//        visited = [[False for _ in range(n)] for _ in range(m)]
//        for i in range(m):
//            for j in range(n):
//                if board[i][j] == word[0]:
//                    if word_search(0, i, j): return True
//        return False
//
//
//s = Solution4()
//b = s.exist(
//    [
//        ["A", "B", "C", "E"],
//        ["S", "F", "C", "S"],
//        ["A", "D", "E", "E"]
//    ],
//    "SEE")
//
//print(b)