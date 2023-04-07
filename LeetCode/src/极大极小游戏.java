public class 极大极小游戏 {
    public static void main(String[] args) {
        System.out.println(new Solution().minMaxGame(new int[]{1, 3, 5, 2, 4, 8, 2, 2}));
    }
    static class Solution {
        public int minMaxGame(int[] nums) {
            int nlen = nums.length;
            while (nlen != 1) {
                int[] new_nums = new int[nlen / 2];
                for (int i = 0; i < (nlen / 2); i++) {
                    nums[i] = i % 2 == 0 ? Math.min(nums[2 * i], nums[2 * i + 1]) : Math.max(nums[2 * i], nums[2 * i + 1]);
                }
                nlen /= 2;
            }
            return nums[0];
        }
    }
}
