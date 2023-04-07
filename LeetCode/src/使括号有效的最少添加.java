public class 使括号有效的最少添加 {
    public static void main(String[] args) {
        System.out.println(new Solution().minAddToMakeValid("((("));
    }
    static class Solution {
        public int minAddToMakeValid(String s) {
            while (s.contains("()")) {
                s = s.replaceAll("\\(\\)", "");
            }
            return s.length();
        }
    }
}
