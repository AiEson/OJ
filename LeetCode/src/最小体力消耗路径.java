import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 最小体力消耗路径 {
    public static void main(String[] args) {
        System.out.println(new Solution().minimumEffortPath(new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}}));
    }
    static class Solution {
        int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};

        List<int[]> adj(int[][] matrix, int x, int y) {
            int m = matrix.length, n = matrix[0].length;
            List<int[]> nei = new ArrayList<>();
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx >= m || nx < 0 || ny >= n || ny < 0) continue;
                nei.add(new int[]{nx, ny});
            }
            return nei;
        }
        class State {
            int x, y;
            int cost;

            State(int x, int y, int cost) {
                this.x = x;
                this.y = y;
                this.cost = cost;
            }
        }
        public int minimumEffortPath(int[][] heights) {
            int ret = 0, m = heights.length, n = heights[0].length;

            int[][] distTo = new int[m][n];
            for (int i = 0; i < m; i++) {
                Arrays.fill(distTo[i], Integer.MAX_VALUE);
            }
            distTo[0][0] = 0;



            return ret;
        }
    }
}
