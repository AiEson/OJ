import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 最长快乐字符串 {
    public static void main(String[] args) {
        System.out.println(new Solution().longestDiverseString(0, 8, 11));
    }
    static class Solution {
        public String longestDiverseString(int a, int b, int c) {
            StringBuilder res = new StringBuilder();
            Pair[] arr = {new Pair(a, 'a'), new Pair(b, 'b'), new Pair(c, 'c')};

            while (true) {
                Arrays.sort(arr, (p1, p2) -> p2.freq - p1.freq);
                boolean hasNext = false;
                for (Pair pair : arr) {
                    if (pair.freq <= 0) {
                        break;
                    }
                    int m = res.length();
                    if (m >= 2 && res.charAt(m - 2) == pair.ch && res.charAt(m - 1) == pair.ch) {
                        continue;
                    }
                    hasNext = true;
                    res.append(pair.ch);
                    pair.freq--;
                    break;
                }
                if (!hasNext) {
                    break;
                }
            }

            return res.toString();
        }

        class Pair {
            int freq;
            char ch;

            public Pair(int freq, char ch) {
                this.freq = freq;
                this.ch = ch;
            }
        }
    }
}
