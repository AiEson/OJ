import java.util.Arrays;

public class 统计异或值在范围内的数对有多少 {
    public static void main(String[] args) {
        System.out.println(new Solution().countPairs(new int[]{1, 4, 2, 7}, 2, 6));
    }
        static class Solution {
            public int countPairs(int[] nums, int low, int high) {
                int sum = 0;
                int len = nums.length;
                Arrays.sort(nums);
                for (int i = 0; i < len - 1; i++) {
                    int ni = nums[i];
                    for (int j = i + 1; j < len; j++) {
                        int ijxor = ni ^ nums[j];
                        if (ijxor <= high && ijxor >= low) ++sum;
                    }
                }
                return sum  ;
            }
        }
}
