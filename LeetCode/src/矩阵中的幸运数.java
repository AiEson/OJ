import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 矩阵中的幸运数{
    public static void main(String[] args) {
        System.out.println(new Solution().luckyNumbers(new int[][]{{7, 8}, {1, 2}}));
    }
    static class Solution {
        public List<Integer> luckyNumbers (int[][] matrix) {
            
            List<Integer> list = new ArrayList<>();
            if(matrix.length == 0) return list;
            int[] lineMin = new int[matrix.length];
            for(int i = 0; i < lineMin.length; i++) lineMin[i] = Integer.MAX_VALUE;
            int[] rowMax = new int[matrix[0].length];
            for(int i = 0; i < rowMax.length; i++) rowMax[i] = -Integer.MAX_VALUE;
            for(int i = 0; i < matrix.length; i++) {
                int[] lines = matrix[i];
                System.out.println(Arrays.toString(lines));
                for(int a : lines) lineMin[i] = Math.min(a, lineMin[i]);
            }
            System.out.println(Arrays.toString(lineMin));
            for(int i = 0; i < matrix[0].length; i++){
                for(int j = 0; j < matrix.length; j++) {
                    rowMax[i] = Math.max(rowMax[i], matrix[j][i]);
                }
            }
            System.out.println(Arrays.toString(rowMax));
            for(int a : lineMin)
                for(int b : rowMax)
                    if(a == b) list.add(a);
            return list;
        }
    }
}