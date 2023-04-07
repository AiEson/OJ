import java.util.Scanner;

public class 统计元音字母序列的数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().countVowelPermutation(new Scanner(System.in).nextInt()));
    }
    static class Solution {
        private static final long rem = (long) 10e9 + 7;
        private static final long rem2=  (long) (Math.pow(10, 9) + 7);
        public int countVowelPermutation(int n) {
            System.out.println(rem);
            System.out.println(rem2);
            long a,e,i,o,u;
            a = e = i = o = u = 1;
            while(--n > 0) {
                long at = e;
                long et = (a + i) % rem;
                long it = ((((a + e) % rem + o) % rem) + u) % rem;
                long ot = (i + u) % rem;
                long ut = a;
                a = at;
                e = et;
                i = it;
                o = ot;
                u = ut;
            }
            return (int)((((((a + e) % rem + i) % rem + o) % rem) + u) % rem);
        }
    }
}
