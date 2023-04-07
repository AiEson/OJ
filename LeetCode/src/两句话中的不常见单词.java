import java.util.*;

public class 两句话中的不常见单词 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().uncommonFromSentences("this apple is sweet", "this apple is sour")));
    }
    static class Solution {
        public String[] uncommonFromSentences(String s1, String s2) {
            Map<String, Integer> map = new HashMap<>();
            for (String s : s1.split(" ")) {
                if (map.containsKey(s)) map.put(s, map.get(s) + 1);
                else map.put(s, 1);
            }
            for (String s : s2.split(" ")) {
                if (map.containsKey(s)) map.put(s, map.get(s) + 1);
                else map.put(s, 1);
            }
            List<String> aa = new ArrayList<>();
            for (String s : map.keySet()) {
                if (map.get(s) == 1) aa.add(s);
            }
            String[] ret = aa.toArray(String[]::new);
            return ret;
        }
    }
}
