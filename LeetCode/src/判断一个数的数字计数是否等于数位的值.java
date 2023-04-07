public class 判断一个数的数字计数是否等于数位的值 {
    public static void main(String[] args) {
        System.out.println(new Solution().digitCount("1210"));
    }
    static class Solution {
        public boolean digitCount(String num) {
            int n = num.length();
            int[] nums = new int[10];
            for (int i = 0; i < n; i++) ++nums[num.charAt(i) - '0'];
            for (int i = 0; i < n; i++) if (num.charAt(i) - '0' != nums[i]) return false;
            return true;
        }
    }
}
