import java.util.Arrays;

public class 删除某些元素后的数组均值 {
    public static void main(String[] args) {
        System.out.println(new Solution().trimMean(new int[]{6, 0, 7, 0, 7, 5, 7, 8, 3, 4, 0, 7, 8, 1, 6, 8, 1, 1, 2, 4, 8, 1, 9, 5, 4, 3, 8, 5, 10, 8, 6, 6, 1, 0, 6, 10, 8, 2, 3, 4}));
    }
    static class Solution {
        public double trimMean(int[] arr) {
            Arrays.sort(arr);
//            System.out.println(Arrays.toString(arr));
            int arrlen = arr.length;
            double sum = 0.;
            int i, cnt = 0;
            for (i = arrlen / 20; i < arrlen - (arrlen / 20); i++) {
                sum += arr[i];
                ++cnt;
//                System.out.print(arr[i] + " ");
            }
            return sum / cnt;
        }
    }
}
