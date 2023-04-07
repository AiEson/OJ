public class 摆动序列 {
    public static void main(String[] args) {
        System.out.println(new Solution().wiggleMaxLength(new int[]{1, 1, 1, 1, 3}));
    }
    static class Solution {
        public int wiggleMaxLength(int[] nums) {
            if (nums.length == 1) return 1;
            int nStat = 0, bStat = 0, cnt = 1;
            for (int i = 0; i < nums.length - 1; i++) {
                //滑窗取状态
                nStat = nums[i + 1] - nums[i];
                //如果出现单调性改变
                if ((nStat > 0 && bStat <= 0) || (nStat < 0 && bStat >= 0)) {
                    bStat = nStat;
                    ++cnt;
                }
            }
            return cnt;
        }
    }
}
