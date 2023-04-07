import java.util.HashMap;
import java.util.Map;

public class 解密消息 {
    public static void main(String[] args) {
        System.out.println(new Solution().decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"));
    }
    static class Solution {
        public String decodeMessage(String key, String message) {
            int[] map = new int[26];
            char iters = 'a';
            for (char c : key.toCharArray())
                if (c != ' ' && map[c - 'a'] == 0)
                    map[c - 'a'] = iters++;
            char[] res = message.toCharArray();
            for (int i = 0; i < res.length; i++) {
                if (res[i] != ' ') {
                    res[i] = (char) map[res[i] - 'a'];
                }
            }
            return new String(res);
        }
    }
}
