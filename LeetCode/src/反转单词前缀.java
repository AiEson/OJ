public class 反转单词前缀 {
    public static void main(String[] args) {
        System.out.println(new Solution().reversePrefix("asda", 'd'));
    }
    static class Solution {
        public String reversePrefix(String word, char ch) {
            int idx = word.indexOf(ch);
            return idx > 0 ? new StringBuilder(word.substring(0, idx + 1)).reverse().append(word.substring(idx + 1, word.length())).toString() : word;
        }
    }
}
