public class 跳跃游戏II {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.jump(new int[]{1, 2, 1, 1, 4}));
        System.out.println(solution.jump(new int[]{2, 3, 1}));
    }
    static class Solution {
        public int jump(int[] nums) {
            if (nums.length == 1) return 0;
            int nPoi = 0;
            int nRange = nums[0] + nPoi;
            int ans = 0;
            int maxPoi = 0, maxRange = 0;
            for (int i = 0; i < nums.length; i++) {
                i = nPoi;
//                System.out.println("i = " + i);
//                System.out.println("ans = " + ans);
                if (i >= nums.length - 1) return ans;
                for (int j = i; j <= nRange; j++) {
                    if (j == nums.length - 1) return ans + 1;
                    if (j + nums[j] >= maxRange) {
                        maxRange = j + nums[j];
                        maxPoi = j;
                    }
                }
                if (nRange != maxRange) ++ans;
                nRange = maxRange;
                nPoi = maxPoi;
            }
            return ans;
        }
    }
}
