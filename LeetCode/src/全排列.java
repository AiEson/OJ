import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 全排列 {
    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        new Solution().permute(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
    }
    static class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ret = new ArrayList<>();
            if (nums.length == 0) return ret;
            Deque<Integer> path = new ArrayDeque<>();
            int len = nums.length;
            boolean[] used = new boolean[len];
            dfs(nums, used, 0, path, len, ret);
            return ret;
        }

        private void dfs(int[] nums, boolean[] used, int deep, Deque<Integer> path, int len, List<List<Integer>> ret) {
            if (deep == len) {
                ret.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < len; i++) {
                if (used[i]) continue;
                used[i] = true;
                path.addLast(nums[i]);
                dfs(nums, used, deep + 1, path, len, ret);
                used[i] = false;
                path.removeLast();
            }
        }
    }
}
