import java.util.ArrayList;
import java.util.List;

public class 最简分数 {
    public static void main(String[] args) {
        System.out.println(new Solution().simplifiedFractions(4));
    }
    static class Solution {
        public List<String> simplifiedFractions(int n) {
            List<String> list = new ArrayList<>();
            for (int i = 2; i <= n; i++) {
                //分母，从2开始
                for (int j = 1; j < i; j++) {
                    //分子，从1开始
                    if (isRltvPrime(i, j)) list.add(j + "/" + i);
                }
            }
            return list;
        }
        private static boolean isRltvPrime(int a, int b) {
            return gcd(a, b) == 1;
        }
        private static int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }
    }
}
