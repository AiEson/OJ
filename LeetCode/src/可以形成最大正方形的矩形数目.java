import java.util.HashMap;
import java.util.Map;

public class 可以形成最大正方形的矩形数目 {
    public static void main(String[] args) {
        System.out.println(new Solution().countGoodRectangles(new int[][]{{5, 8}, {3, 9}, {5, 12}, {16, 5}}));
    }
    static class Solution {
        public int countGoodRectangles(int[][] rectangles) {
            if (rectangles.length == 0) return 0;
            Map<Integer, Integer> map = new HashMap<>();
            int max = -Integer.MAX_VALUE;
            for (int[] rectangle : rectangles) {
                int min = Math.min(rectangle[0], rectangle[1]);
                max = Math.max(min, max);
                map.put(min, map.containsKey(min) ? map.get(min) + 1 : 1);
            }
            return map.get(max);
        }
    }
}
