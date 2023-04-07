import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 重新排列单词间的空格 {
    public static void main(String[] args) {
        System.out.println(new Solution().reorderSpaces(
                "  this   is  a sentence "));
    }
    static class Solution {
        public String reorderSpaces(String text) {
            List<String> words = new ArrayList<>();
            int spaces = 0;
            StringBuilder sb = new StringBuilder();
            boolean flag = false;
            for (char c : text.toCharArray()) {
                if (c == ' ') {
                    ++spaces;
                    if (flag) {
                        flag = false;
                        words.add(sb.toString());
                        sb = new StringBuilder();
                    }
                }
                else {
                    sb.append(c);
                    flag = true;
                }
            }
            if (sb.length() != 0) words.add(sb.toString());
            sb = new StringBuilder();
            int end = words.size() - 1 == 0 ? spaces : spaces % (words.size() - 1);
//            System.out.println(end  );
            int avg = words.size() - 1 == 0 ? 0 : (spaces - end) / (words.size() - 1);
            for (int i = 0; i < avg; i++) sb.append(" ");
            String space = sb.toString();
            sb = new StringBuilder().append(words.get(0));
            for (int i = 1; i < words.size(); i++) sb.append(space).append(words.get(i));
            for (int i = 0; i < end; i++) sb.append(" ");
            return sb.toString();
        }
    }
}
