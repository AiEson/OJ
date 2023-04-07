public class 爬楼梯 {
    public static void main(String[] args) {
        new Solution().climbStairs(12);
    }
    static class Solution {
        //状态转移,往上爬 n 个台阶所需要的方案数
        static int[] f = new int[49];

        public int climbStairs(int n) {
            int ans = 0;
            f[0] = 0;
            f[1] = 1;
            //f[i] = f[i - 1] + f[i - 2]
            for (int i = 3; i <= n + 3; i++) {
                f[i] = f[i - 1] + f[i - 2];
            }
            return f[n + 3];
        }
    }
}
