import java.util.Arrays;

public class 还原排列的最少操作步数 {
    public static void main(String[] args) {
        System.out.println(new Solution().reinitializePermutation(8));
    }
    static class Solution {
        public int reinitializePermutation(int n) {
            int ans = 0;
            int i = 1;
            i = n / 2; // 先做一次偏移，用来跑起来循环
            while (i != 1) {
                ++ans;
                i = i % 2 == 0 ? i / 2 : n / 2 + (i - 1) / 2; // 更新i
            }
            return ans + 1;
        }

    }
}
