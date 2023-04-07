import com.sun.source.tree.IfTree;

import java.util.Arrays;

public class 球会落何处 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findBall(new int[][]{{1, 1, 1, -1, -1}, {1, 1, 1, -1, -1}, {-1, -1, -1, 1, 1}, {1, 1, 1, 1, -1}, {-1, -1, -1, -1, -1}})));
        System.out.println(Arrays.toString(new Solution().findBall(new int[][]{{-1}})));
        System.out.println(Arrays.toString(new Solution().findBall(new int[][]{{1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}, {1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}})));
    }
    static class Solution {
        public int[] findBall(int[][] grid) {
            int dep = grid.length;
            int wid = grid[0].length;
            int[] ret = new int[wid];
            for (int i = 0; i < wid; i++) {
                int ballId = i;
                int ballPosi = ballId, ballDeep = 0;
                while (ballDeep != dep) {
                    if ((ballPosi == 0 && grid[ballDeep][ballPosi] == -1) || (ballPosi == wid - 1 && grid[ballDeep][ballPosi] == 1)){
                        ballPosi = -1;
                        break;
                    } else {
                        int nStat = grid[ballDeep][ballPosi];
                        if (nStat == grid[ballDeep][ballPosi + nStat]) {
                            ++ballDeep;
                            ballPosi += nStat;
                        } else {
                            ballPosi = -1;
                            break;
                        }
                    }
                }
                ret[ballId] = ballPosi;
            }
            return ret;
        }
    }
}
