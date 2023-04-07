public class 有界数组中指定下标处的最大值 {
    public static void main(String[] args) {
        System.out.println(new Solution().maxValue(6, 1, 10));
    }
    static class Solution {
        private int sum(int from, int to) {
            int sum = 0;
            for (int i = from; i <= to; i++) {
                sum += i;
            }
            return sum;
        }
        public int maxValue(int n, int index, int maxSum) {
            int max_x = (maxSum + sum(0, n / 2) + sum(0, n - (n / 2) - 1)) / n;
            System.out.println("Max X: " + max_x);


            int x = max_x, sum = 0;
            while (sum <= maxSum) {
                int left = sum(0, index);
                int right = sum(0, n - index - 1);
                sum = x * n - left - right;
                System.out.println(sum);
            }
            return 0;
        }
    }
}
