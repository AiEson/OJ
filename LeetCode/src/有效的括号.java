public class 有效的括号 {
    public static void main(String[] args) {
        System.out.println(new Solution().isValid("()}[]{}"));
    }
    static class Solution {
        public boolean isValid(String s) {
            int length = s.length() / 2;
            for (int i = 0; i < length; i++) {
                s = s.replace("()", "").replace("{}", "").replace("[]", "");
            }

            return s.length() == 0;
        }
    }
}
