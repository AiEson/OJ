import java.util.Arrays;

public class 生成平衡数组的方案数 {
    public static void main(String[] args) {
        System.out.println(new Solution().waysToMakeFair(new int[]{2, 1, 6, 4}));
    }
    static class Solution {
        public int waysToMakeFair(int[] nums) {
            int ret = 0;
            int nlen = nums.length;
            int[] odd = new int[nlen];
            int[] even = new int[nlen];
            for (int i = 0; i < nlen; i++) {
                if (i % 2 == 0) {
                    even[i] = i == 0 ? nums[i] : even[i - 1] + nums[i];
                    odd[i] = i == 0 ? 0 : odd[i - 1];
                } else {
                    odd[i] = i == 0 ? nums[i] : odd[i - 1] + nums[i];
                    even[i] = i == 0 ? 0 : even[i - 1];
                }
            }
            for (int i = 0; i < nlen; i++) {
                int left_odd = i == 0 ? 0 : odd[i - 1];
                int left_even = i == 0 ? 0 : even[i - 1];
                int right_odd = i == nlen - 1 ? 0 : odd[nlen - 1] - odd[i];
                int right_even = i == nlen - 1 ? 0 : even[nlen - 1] - even[i];
                if (left_odd + right_even == left_even + right_odd) {
                    ret++;
                }
            }
            return ret;
        }
    }
}
