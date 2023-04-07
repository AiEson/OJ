import java.util.HashSet;
import java.util.Set;

public class 使数组中所有元素都等于零 {
    public static void main(String[] args) {
        System.out.println(new Solution().minimumOperations(new int[]{1, 5, 0, 3, 5}));
    }
    static class Solution {
        public int minimumOperations(int[] nums) {
            Set<Integer> set = new HashSet<>(nums.length);
            for (int num : nums) {
                if (num != 0) set.add(num);
            }
            return set.size();
        }
    }
}
