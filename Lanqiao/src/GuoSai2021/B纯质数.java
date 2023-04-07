package GuoSai2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B纯质数 {
    public static int countPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= n; i++)
            if (isPrime[i])
                for (int j = i * i; j <= n; j += i)
                    isPrime[j] = false;
        int count = 0;
        l1: for (int i = 2; i <= n; i++)
            if (isPrime[i]) {
                // 质数是 i ，接下来解析成char 数组
                char[] chars = (i + "").toCharArray();
                for (char aChar : chars) {
                    if (!isPrime[Integer.parseInt(String.valueOf(aChar))]) continue l1;
                }
                ++count;
            }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(20210605));
    }
}
