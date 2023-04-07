public class 将数字变成0的操作次数 {
    public static void main(String[] args) {
        System.out.println(new Solution().numberOfSteps(123));
    }
    static class Solution {
        public int numberOfSteps(int num) {
            int cnt = 0;
            while (num != 0) {
                ++cnt;
                num = num % 2 == 0 ? num >> 1 : num - 1;
            }
            return cnt;

        }
    }
}
