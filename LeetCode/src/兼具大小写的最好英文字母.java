import java.util.HashMap;
import java.util.Map;

public class 兼具大小写的最好英文字母 {
    public static void main(String[] args) {
        System.out.println((int)'a' + " " + (int)'A');
        System.out.println(new Solution().greatestLetter("arRAzFif"));
    }
    static class Solution {
        public String greatestLetter(String s) {
            int[] arr = new int['z' + 1];
            for (char c : s.toCharArray()) {
                ++arr[c];
            }
            for (int i = 90; i >= 65; --i) {
                if (arr[i] > 0 && arr[i + 32] > 0) {
                    return String.valueOf((char) i);
                }
            }
            return "";
        }
    }
}
