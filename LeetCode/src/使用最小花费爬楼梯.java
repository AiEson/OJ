import java.util.Arrays;

public class 使用最小花费爬楼梯 {
    public static void main(String[] args) {
        System.out.println(new Solution().minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
    static class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int[] dp = new int[1010];
            dp[0] = 0;
            dp[1] = 0;
            //f[i] = f[i - 1] + f[i - 2]
            int n = cost.length;
            for (int i = 2; i <= n; ++i)
                dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2]+ cost[i - 2]);
            return dp[cost.length];
        }
    }
}
