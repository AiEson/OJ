public class 最长公共前缀 {
    public static void main(String[] args) {
        System.out.println(new Solution().longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }
    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            StringBuilder sb = new StringBuilder();
            int idx = 0;
            String stt_0 = strs[0];
            while (true){
                char c = 0;
                boolean flag = true;
                for (String str : strs) {
                    if (idx > str.length() - 1) {
                        flag = false;
                        break;
                    }
                    if (c == 0) c = str.charAt(idx);
                    if (c != str.charAt(idx)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    ++idx;
                    sb.append(c);
                } else break;

            }
            return sb.toString();
        }
    }
}
