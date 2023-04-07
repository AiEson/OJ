public class 七进制数 {
    public static void main(String[] args) {
        System.out.println(new Solution().convertToBase7(-7     ));
    }
    static class Solution {
        public String convertToBase7(int num) {
                if (num < 0) return "-" + convertToBase7(-num);
                if (num == 0) return "0";
                StringBuilder sb = new StringBuilder();
                while (num != 0) {
                    sb.append(num % 7);
                    num /= 7;
                }
                return sb.reverse().toString();
        }
    }
}
