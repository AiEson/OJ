import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class 删除有序数组中的重复项 {
    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }
    static class Solution {
        public int removeDuplicates(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums)
                set.add(num);
            return set.size();
        }
    }
}
