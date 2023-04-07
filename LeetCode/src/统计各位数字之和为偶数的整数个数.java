public class 统计各位数字之和为偶数的整数个数 {
    public static void main(String[] args) {
        System.out.println(new Solution().countEven(30));
        System.out.println(new Solution().check(12));
    }
    static class Solution {

        public boolean check(int a) {
            int sum = 0;
            while (a > 0) {
                sum += a % 10;
                a /= 10;
            }
            return sum % 2 == 0;
        }
        public int countEven(int num) {
            int sum = 0;
            for (int i = 2; i <= num; i++) {
                if (check(i)) ++ sum;
            }
            return sum;
        }
    }
}
