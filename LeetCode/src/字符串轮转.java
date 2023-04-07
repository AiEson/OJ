import java.util.HashMap;
import java.util.Map;

public class 字符串轮转 {
    public static void main(String[] args) {
        System.out.println(new Solution().isFlipedString("waterbottle", "erbottlewat"));
    }
    static class Solution {
        public boolean isFlipedString(String s1, String s2) {
            if (s1.length() != s2.length()) return false;
            s1 += s1;
            return s1.contains(s2);
        }
    }
}
