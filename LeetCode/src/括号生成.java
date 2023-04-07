import java.util.*;

public class 括号生成 {
    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }
    static class Solution {
        public List<String> generateParenthesis(int n) {
            if (n == 1) {
                return Arrays.asList("()");
            }
            Set<String> hs = new HashSet<>();
            for (String s : generateParenthesis(n-1)) {
                for (int i = 0; i < 2*n-2; i++) {
                    hs.add(s.substring(0,i) + "()" + s.substring(i));
                }
            }
            return new ArrayList(hs);
        }
    }
}
