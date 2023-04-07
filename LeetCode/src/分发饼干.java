import java.util.Arrays;

public class 分发饼干 {
    public static void main(String[] args) {
        System.out.println(new Solution().findContentChildren(new int[]{1, 2, 3}, new int[]{}));
    }
    static class Solution {
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            int cnt = 0;
//            loop: for (int i = 0; i < g.length; i++) {
//                for (int j = 0; j < s.length; j++) {
//                    if (s[j] >= g[i]) {
//                        ++cnt;
//                        s[j] = -1;
//                        continue loop;
//                    }
//                }
//            }
            int maxIdx = s.length - 1;
            for (int i = g.length - 1; i >= 0; i--) {
                if (maxIdx >= 0 && g[i] <= s[maxIdx]) {
                    ++cnt;
                    --maxIdx;
                }
            }
            return cnt;
        }
    }
}
