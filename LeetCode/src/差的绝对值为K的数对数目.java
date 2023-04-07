public class 差的绝对值为K的数对数目 {
    public static void main(String[] args) {
        System.out.println(new Solution().countKDifference(new int[]{1, 2, 2, 1},  1));
    }
    static class Solution {
        public int countKDifference(int[] nums, int k) {
            int cnt = 0;
            for (int i = 0; i < nums.length; i++)
                for (int j = i + 1; j < nums.length; j++)
                    cnt += Math.abs(nums[i] - nums[j]) == k ? 1 : 0;

            return cnt;
        }
    }
}
