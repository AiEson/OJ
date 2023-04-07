import java.util.*;

public class 查找和最小的K对数字 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] num1 = {1, 2};
        int[] num2 = {3};
        solution.kSmallestPairs(num1, num2, 3);
    }
    static class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            List<List<Integer>> ret = new ArrayList<>(k);
            for (int i : nums1) {
                for (int j : nums2) {
                    ret.add(Arrays.asList(i, j));
                }
            }
            ret.sort(Comparator.comparingInt(o -> o.get(0) + o.get(1)));
            int min = Math.min(ret.size(), k);
            return ret.subList(0, min);
        }
    }
}
