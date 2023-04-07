public class 唯一元素的和 {
    public static void main(String[] args) {
        System.out.println(new Solution().sumOfUnique(new int[]{1, 1, 1, 1, 1}));
    }
    static class Solution {

        public int sumOfUnique(int[] nums) {
            int[] ints = new int[101];
            int rst = 0;
            for (int num : nums) {
                ++ints[num];
            }
            for (int i = 0; i < ints.length; i++) {
                rst += ints[i] == 1 ? i : 0;
            }
            return rst;
        }
    }
}
