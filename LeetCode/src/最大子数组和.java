import java.util.Arrays;

public class 最大子数组和 {
    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
    static class Solution {
        public int maxSubArray(int[] nums) {
            // 贪心解法
//            int rst = 0, max = -Integer.MAX_VALUE;
//            for (int num : nums) {
//                rst += num;
//                max = Math.max(rst, max);
//                if (rst < 0) rst = 0;
//            }
//            return max;

            //DP解法
            /*
            设状态 dp[i] 为第 i 个时当前的最大子数组和，则可能：
            - i - 1 在同一个背包中，则 dp[i] = dp[i - 1] + num[i]
            - i - 1 不在同一个背包中，则 dp[i] = num[i]
            求解最大，则 dp[i] = Max(上面两种)
             */
            int[] dp = new int[100010];
            System.out.println(dp.length);
            dp[0] = nums[0];
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }
}
