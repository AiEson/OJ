import java.util.HashMap;
import java.util.Map;

public class 统计一个数组中好对子的数目 {
    public static void main(String[] args) {
        System.out.println(new Solution().countNicePairs(new int[]{13,10,35,24,76}));
    }
    static class Solution {

        public static int rev(int n) {
            StringBuffer sb  = new StringBuffer();
            sb.append(n);
            sb.reverse();
            return Integer.parseInt(sb.toString());
        }
        public int countNicePairs(int[] nums) {
            int ret = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int key = rev(nums[i]) - nums[i];
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            for (Integer integer : map.keySet()) {
                int val = map.get(integer);
                ret += ((long) val * (val - 1) / 2) % (1000000007);
            }
            return ret % 1000000007;
        }
    }
}
