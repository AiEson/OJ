import java.util.HashMap;

public class 和为K的子数组 {
    public static void main(String[] args) {
        System.out.println(new Solution().subarraySum(new int[]{1, 2, 3}, 3));
    }
    static class Solution {
        public int subarraySum(int[] nums, int k) {
            int[] perSum = new int[nums.length + 1];
            perSum[0] = 0;
            for (int i = 1; i <= nums.length; i++) {
                perSum[i] = perSum[i - 1] + nums[i - 1];
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < perSum.length; i++) {
                if(!map.containsKey(perSum[i]))
                    map.put(perSum[i], i);
            }
            int max = 0;
            for (int i = 1; i < perSum.length; i++) {
                if(map.containsKey(k + perSum[i]))
                    max = Math.max(max, i - map.get(k - perSum[i]));
            }
            return max;
        }
    }
}
