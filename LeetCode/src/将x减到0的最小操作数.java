import java.util.Arrays;

public class 将x减到0的最小操作数 {
    public static void main(String[] args) {
        System.out.println(new Solution().minOperations(new int[]{1,1}, 3));
    }
    static class Solution {
        public int minOperations(int[] nums, int x) {
            // 前缀和
            int len = nums.length;
            int[] pre = new int[len + 1];
            for (int i = 0; i < len; i++) {
                pre[i + 1] = pre[i] + nums[i];
            }
            int[] suf = new int[len + 1];
            for (int i = 0; i < len; i++) {
                suf[i + 1] = suf[i] + nums[len - i - 1];
            }
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < pre.length; i++) {
                int ii = pre[i];
                if (ii > x) break;
                int j = Arrays.binarySearch(suf, x - ii);
                if (j < 0 || i + j > len) continue;
                ans = Math.min(ans, i + j);
            }
            return ans == Integer.MAX_VALUE ? -1 : ans;

        }
    }
}
