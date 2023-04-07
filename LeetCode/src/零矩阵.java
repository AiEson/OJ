import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 零矩阵 {
    public static void main(String[] args) {
        new Solution().setZeroes(new int[][]{{1,1,1}, {1,0,1}, {1,1,1}});
    }
    static class Solution {
        public void setZeroes(int[][] matrix) {
            int xLength = matrix[0].length;
            int yLength = matrix.length;
            List<Integer> xList = new ArrayList<>(), yList = new ArrayList<>();
            for (int y = 0; y < matrix.length; y++) {
                int[] line = matrix[y];
                for (int x = 0; x < line.length; x++) {
                    if (line[x] == 0) {
                        xList.add(x);
                        yList.add(y);
                    }
                }
            }
            // matrix[y][x]
            for (int i = 0; i < xList.size(); i++) {
                int cleany = yList.get(i), cleanx = xList.get(i);
                for (int i1 = 0; i1 < xLength; i1++) {
                    matrix[cleany][i1] = 0;
                }
                for (int i1 = 0; i1 < yLength; i1++) {
                    matrix[i1][cleanx] = 0;
                }
            }
        }
    }
}
