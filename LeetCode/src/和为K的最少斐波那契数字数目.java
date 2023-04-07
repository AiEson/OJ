import java.util.Arrays;

public class 和为K的最少斐波那契数字数目 {
    public static void main(String[] args) {
        System.out.println(new Solution().findMinFibonacciNumbers(19));
//        int[] a = new int[100010];
//        a[1] = 1;
//        a[2] = 1;
//        for (int i = 3; true; i++) {
//            a[i] = a[i - 1] + a[i - 2];
//            if (a[i] > 1000000000) break;
//        }
//        System.out.println(Arrays.toString(a));
    }
    static class Solution {
        static int[] fbarr = new int[]{1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170};
        public int findMinFibonacciNumbers(int k) {
            int cnt = 0;
            while (k > 0) {
                for (int i = fbarr.length - 1; i >= 0; i--) {
                    if (k >= fbarr[i]) {
                        ++cnt;
                        k -= fbarr[i];
                    }
                }
            }
            return cnt;
        }
    }
}
