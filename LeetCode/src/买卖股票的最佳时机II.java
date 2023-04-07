public class 买卖股票的最佳时机II {
    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{2, 4, 1}));
    }
    static class Solution {
        public int maxProfit(int[] n) {
            int cnt = 0;
            for (int i = 0; i < n.length - 1; i++) {
                int now = n[i + 1] - n[i];
                cnt += Math.max(now, 0);
            }
            return cnt;
        }
    }
}
