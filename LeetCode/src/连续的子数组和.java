import java.util.HashMap;

public class 连续的子数组和 {
    public static void main(String[] args) {
        System.out.println(new Solution().checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
    }
    static class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {
            if (nums.length < 2) return false;
            int[] perSum = new int[nums.length +1];
            perSum[0] = 0;
            for (int i = 1; i <= nums.length; i++) {
                perSum[i] = perSum[i - 1] + nums[i - 1];
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < perSum.length; i++) {
                int should = perSum[i] % k;
                if (!map.containsKey(should))
                    map.put(should, i);
            }
            int max = 0;
            for (int i = 1; i < perSum.length; i++) {
                max = Math.max(max, i - map.get(perSum[i] % k));
            }
            return max > 1;
        }
    }
}
