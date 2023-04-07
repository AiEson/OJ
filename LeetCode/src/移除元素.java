public class 移除元素 {
    public static void main(String[] args) {
        System.out.println(new Solution().removeElement(new int[]{2,2,3,3}, 2));
    }
    static class Solution {
        public int removeElement(int[] nums, int val) {
            int j = -1;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] != val)
                    nums[++j] = nums[i];
            }
            return j + 1;
        }
    }
}
