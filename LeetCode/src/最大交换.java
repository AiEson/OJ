import java.util.Arrays;

public class 最大交换 {
    public static void main(String[] args) {
        System.out.println(new Solution().maximumSwap(3421));
    }
    static class Solution {
        public int maximumSwap(int num) {
            char[] maxarr = (num + "").toCharArray();
            int max_idx = -1, max = -1;
            for (int i = maxarr.length - 1; i >= 0; i--) {
                if(max < maxarr[i]) {
                    max = maxarr[i];
                    max_idx = i;
                }
            }
            if (max_idx != -1) {
                char tmp = maxarr[0];
                maxarr[0] = maxarr[max_idx];
                maxarr[max_idx] = tmp;
            }
            StringBuilder sb = new StringBuilder();
            for (char c : maxarr) {
                sb.append(c);
            }
            return Integer.parseInt(sb.toString());
        }
    }
}
