import java.util.Arrays;

public class 网格照明 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().gridIllumination(5, new int[][]{{0, 4}, {0, 0}}, new int[][]{{0, 4}, {0, 1},{1, 4}})));
    }
    static class Solution {
        public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
            int[] ret = new int[queries.length];
            boolean[] stat = new boolean[lamps.length];
            loop1: for (int i = 0; i < queries.length; i++) {
                int[] query = queries[i];
                int qx = query[0], qy = query[1];
                for (int j = 0, lampsLength = lamps.length; j < lampsLength; j++) {
                    if (stat[j]) continue;
                    int[] ints = lamps[j];
                    if (isValid(ints[0], ints[1], qx, qy)) {
                        //如果对角线或直线判定成立，进行输出1
                        ret[i] = 1;
                        //执行关灯操作
                        for (int i1 = lamps.length - 1; i1 >= 0; i1--) {
                            if (stat[i1]) continue ;
                            int[] tmp = lamps[i1];
                            if (isInRange(tmp[0], tmp[1], qx, qy)) {
                                //如果成立，则删除
                                stat[i1] = true;
                            }
                        }
                        continue loop1;
                    }
                }
                ret[i] = 0;
            }
            return ret;
        }
        private static boolean isValid(int x1, int y1, int x2, int y2){
            return (isDjx(x1, y1, x2, y2) || isLine(x1, y1, x2, y2));
        }
        private static boolean isInRange(int x1, int y1, int x2, int y2) {
            return Math.abs(x1 - x2) <= 1 && Math.abs(y1 - y2) <= 1;
        }
        private static boolean isLine(int x1, int y1, int x2, int y2) {
            return x1 == x2 || y1 == y2;
        }
        private static boolean isDjx(int x1, int y1, int x2, int y2) {
            return Math.abs(x1 - x2) == Math.abs(y1 - y2);
        }
    }
}
