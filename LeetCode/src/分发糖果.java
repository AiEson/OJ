import java.util.Arrays;

public class 分发糖果 {
    public static void main(String[] args) {
        System.out.println(new Solution().candy(new int[]{1, 2, 87, 87, 87, 2, 1}));
        //                                                0 1 2  0  2  1 0
    }

    //    static class Solution {
//        public int candy(int[] ratings) {
//            int rst = 0;
//            //滑窗
//            int[] arr = new int[ratings.length];
//            int befRst = -1;
//            boolean isChanged = true;
//            while (isChanged) {
//                isChanged = false;
//                for (int i = 0; i < ratings.length - 1; i++) {
//                    if (ratings[i] > ratings[i + 1]) {
//                        if (arr[i] <= arr[i + 1]) {
//                            arr[i] += 1;
//                            isChanged = true;
//                        }
//                    } else if (ratings[i] < ratings[i + 1]) {
//                        if (arr[i + 1] <= arr[i]) {
//                            arr[i + 1] += 1;
//                            isChanged = true;
//                        }
//                    }
//
//                }
//
//            }
//            for (int ii : arr) {
//                rst += ii;
//            }
//            return rst + ratings.length;
//        }
//    }
    static class Solution {
        public int candy(int[] ratings) {
            int[] arr = new int[ratings.length];
            //正向滑窗
            for (int i = 0; i < ratings.length - 1; i++) {
                if (ratings[i + 1] > ratings[i]) arr[i + 1] += arr[i] + 1;
            }
            for (int i = ratings.length - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1]) arr[i] = Math.max(arr[i], arr[i + 1] + 1);
            }
            return ratings.length + Arrays.stream(arr).sum();
        }
    }
}
