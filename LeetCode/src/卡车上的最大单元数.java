import java.util.Arrays;
import java.util.Comparator;

public class 卡车上的最大单元数 {
    public static void main(String[] args) {
        System.out.println(new Solution().maximumUnits(new int[][]{{5, 10}, {2, 5}, {4, 7},{3,9}}, 10));
    }

    static class Solution {
        public int maximumUnits(int[][] boxTypes, int truckSize) {
            Arrays.sort(boxTypes, (o1, o2) -> o2[1] - o1[1]);
            System.out.println(Arrays.deepToString(boxTypes));
            int sum = 0;
            for (int[] boxType : boxTypes) {
                if (boxType[0] <= truckSize) {
                    sum += boxType[0] * boxType[1];
                    truckSize -= boxType[0];
                } else {
                    sum += truckSize * boxType[1];
                    break;
                }
            }
            return sum;
        }
    }
}
