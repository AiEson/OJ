public class 增量元素之间的最大差值 {
    public static void main(String[] args) {
        System.out.println(new Solution().maximumDifference(new int[]{9,4,1}));
    }
    static class Solution {
        public int maximumDifference(int[] nums) {
            int befMax = nums[nums.length - 1];
            int rst = - Integer.MAX_VALUE;
            for (int i = nums.length - 2; i >= 0; i--) {
                rst = Math.max(befMax - nums[i], rst);
                befMax = Math.max(nums[i], befMax);
            }
            return rst <= 0 ? -1 : rst;
        }
    }
}
