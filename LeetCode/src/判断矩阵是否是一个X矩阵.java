public class 判断矩阵是否是一个X矩阵 {
    public static void main(String[] args) {
        System.out.println(new Solution().checkXMatrix(new int[][]{{2, 0, 0, 1}, {0, 3, 1, 0}, {0, 5, 2, 0}, {4, 0, 0, 2}}));
    }
    static class Solution {
        public boolean checkXMatrix(int[][] grid) {
            int N = grid.length;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j || i + j == N - 1) {
                        // 对角线
                        if (grid[i][j] == 0) return false;
                    } else {
                        if (grid[i][j] != 0) return false;
                    }
                }
            }
            return true;
        }
    }
}
