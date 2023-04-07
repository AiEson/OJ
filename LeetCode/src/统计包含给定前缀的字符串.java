public class 统计包含给定前缀的字符串 {
    public static void main(String[] args) {
        System.out.println(new Solution().prefixCount(new String[]{"pay", "attention", "practice", "attend"}, "at"));
    }
    static class Solution {
        public int prefixCount(String[] words, String pref) {
            int sum = 0, max_len = pref.length();
            l1: for (String word : words) {
                if (word.startsWith(pref))
                    ++sum;
            }
            return sum;
        }
    }
}
