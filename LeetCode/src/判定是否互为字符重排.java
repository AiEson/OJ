import java.util.HashMap;
import java.util.Map;

public class 判定是否互为字符重排 {
    public static void main(String[] args) {
        System.out.println(new Solution().CheckPermutation("abc", "cba"));
    }
    static class Solution {
        public boolean CheckPermutation(String s1, String s2) {
            if (s1.length() != s2.length()) return false;
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s1.length(); i++) {
                char s1c = s1.charAt(i);
                if (map.containsKey(s1c)) {
                    map.put(s1c, map.get(s1c)+1);
                } else map.put(s1c, 1);
            }
            for (int i = 0; i < s1.length(); i++) {
                char s1c = s2.charAt(i);
                if (map.containsKey(s1c)) {
                    map.put(s1c, map.get(s1c)-1);
                } else map.put(s1c, -1);
            }
            for (Character character : map.keySet()) {
                if (map.get(character) != 0) return false;
            }
            return true;
        }
    }
}
