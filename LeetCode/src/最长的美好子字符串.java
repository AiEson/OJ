import java.util.HashSet;
import java.util.Set;

public class 最长的美好子字符串 {
    public static void main(String[] args) {
        new Solution().longestNiceSubstring("");
    }
    static class Solution {
        public String longestNiceSubstring(String s) {
            int n = s.length();
            String ans = "";
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (j - i + 1 > ans.length() && check(s.substring(i, j + 1))) ans = s.substring(i, j + 1);
                }
            }
            return ans;
        }
        boolean check(String s) {
            Set<Character> set = new HashSet<>();
            for (char c : s.toCharArray()) set.add(c);
            for (char c : s.toCharArray()) {
                char a = Character.toLowerCase(c), b = Character.toUpperCase(c);
                if (!set.contains(a) || !set.contains(b)) return false;
            }
            return true;
        }
    }
}
