import java.util.HashMap;
import java.util.Map;

public class 第一个出现两次的字母 {
    public static void main(String[] args) {
        System.out.println(new Solution().repeatedCharacter("abccbaacz"));
    }
    static class Solution {
        public char repeatedCharacter(String s) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : s.toCharArray()) {
                int n = map.getOrDefault(c, 0);
                if (n == 1) return c;
                map.put(c, n + 1);
            }
            return ' ';
        }
    }
}
