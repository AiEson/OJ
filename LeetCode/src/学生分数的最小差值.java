import java.util.Arrays;
import java.util.stream.IntStream;

public class 学生分数的最小差值 {
    public static void main(String[] args) {
        System.out.println(new Solution().minimumDifference(new int[]{9, 4, 1, 7}, 2));
    }
    static class Solution {
        public int minimumDifference(int[] nums, int k) {
            if (k == 1) return 0;
            Arrays.sort(nums);
            int rst = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length - k + 1; i++)
                rst = Math.min(rst, nums[i + k - 1] - nums[i]);
            return rst;
        }
    }
}
