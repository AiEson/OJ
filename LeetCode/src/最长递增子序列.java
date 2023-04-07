import java.util.Arrays;

public class 最长递增子序列 {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
    static class Solution {
        public int lengthOfLIS(int[] nums) {
            //dp[i] 为第 i 个时的最长子序列的长度
            int[] dp = new int[2510];
            Arrays.fill(dp, 1);
            int max = -1;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j <= i; j++) {
                    if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }
}
