import java.util.*;

public class 优美的排列II {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().constructArray(3, 1)));
    }
    static class Solution {
        static List<Integer> rst;
        public Object[] constructArray(int n, int k) {
            rst = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                rst.add(i + 1);
            }

//            1 2 3 4 5
//
//            1 5 2 3 4
            return rst.toArray();
        }

        private static boolean judge(int k){
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < rst.size() - 1; i++) {
                set.add(Math.abs(rst.get(i + 1) - rst.get(i)));
            }
            return set.size() == k;
        }

    }
}
