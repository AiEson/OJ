public class 整数反转 {
    public static void main(String[] args) {
        System.out.println(new Solution().reverse(1534236469));
    }
    static class Solution {
        public int reverse(int x) {
            try {
                return x < 0 ? Integer.parseInt("-" + new StringBuilder(-x + "").reverse())
                        : Integer.parseInt(new StringBuilder(x + "").reverse().toString());
            }catch (Exception e) {
                return 0;
            }
        }
    }
}
