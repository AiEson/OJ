import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class 至少在两个数组中出现的值 {
    public static void main(String[] args) {
        System.out.println(new Solution().twoOutOfThree(new int[]{1, 1, 3, 2}, new int[]{2, 3}, new int[]{3}));
    }

    static class Solution {
        public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
            List<Integer> list = new ArrayList<>();
            Map<Integer, Integer> map = new HashMap<>();

            Set<Integer> set1 = new HashSet<>();
            for (int i : nums1) {
                set1.add(i);
            }

            Set<Integer> set2 = new HashSet<>();
            for (int i : nums2) {
                set2.add(i);
            }
            Set<Integer> set3 = new HashSet<>();
            for (int i : nums3) {
                set3.add(i);
            }

            for (int i : set1) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
            for (int i : set2) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
            for (int i : set3) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
            for (Integer i : map.keySet()) {
                if (map.get(i) >= 2) list.add(i);
            }
            return list;
        }
    }
}
