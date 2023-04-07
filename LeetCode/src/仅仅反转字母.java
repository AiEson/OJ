import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class 仅仅反转字母 {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
    static class Solution {
        public String reverseOnlyLetters(String s) {
            Deque<Character> chars = new ArrayDeque<>();
            for (char c : s.toCharArray()) {
                if (Character.isLetter(c))
                    chars.add(c);
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (char c : s.toCharArray()) {
                if (Character.isLetter(c))
                    stringBuffer.append(chars.removeLast());
                else
                    stringBuffer.append(c);
            }
            System.out.println(stringBuffer);
            return stringBuffer.toString();
        }
    }
}
