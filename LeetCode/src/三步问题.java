import java.util.Arrays;

public class 三步问题 {
    public static void main(String[] args) {
        System.out.println(new Solution().waysToStep(3));
    }
    static class Solution {
        public int waysToStep(int n) {
            int[] dp = new int[1000010];
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                dp[i] = (((dp[i - 3] + dp[i - 2]) % 1000000007) + dp[i - 1]) % 1000000007;
            }
            return dp[n];
        }
    }
}
