public class 重排字符形成目标字符串 {
    public static void main(String[] args) {
        System.out.println(new Solution().rearrangeCharacters("abcba", "abc"));
    }
    static class Solution {
        public int rearrangeCharacters(String s, String target) {
            int cnt = Integer.MAX_VALUE;
            int[] cnts = new int[26];
            for (int i = 0; i < target.length(); i++) {
                ++cnts[target.charAt(i) - 'a'];
            }
            int[] cnts2 = new int[26];
            for (char c : s.toCharArray()) {
                ++cnts2[c - 'a'];
            }
            for (int i = 0; i < cnts.length; i++) {
                int nc = cnts[i];
                if (nc == 0) continue;
                cnt = Math.min(cnts2[i] / nc, cnt);
            }
            return cnt;
        }
    }
}
