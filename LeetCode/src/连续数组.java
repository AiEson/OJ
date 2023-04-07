import java.util.HashMap;
import java.util.Map;

public class 连续数组 {
    public static void main(String[] args) {
        System.out.println(new Solution().findMaxLength(new int[]{0, 1, 0}));
    }
    static class Solution {
        HashMap<Integer, Integer> map = new HashMap<>();
        public int findMaxLength(int[] nums) {
            int sum = 0;
            int[] perSum = new int[nums.length + 1];
            perSum[0] = 0;
            for (int i = 1; i <= nums.length; i++) {
                perSum[i] = perSum[i - 1] + (nums[i - 1] == 0 ? -1 : 1);
            }
            for (int i = 0; i < perSum.length; i++) {
                if (!map.containsKey(perSum[i])) {
                    map.put(perSum[i], i);
                }
            }
            int maxx = -1;
            for (int i = 1; i < perSum.length; i ++ ) {
                int need = perSum[i];
                maxx = Math.max(maxx, i - map.get(need));
            }
            return maxx;
        }
    }
}
