package Guosai2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B {
    public static List<Integer> countPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        List<Integer> ret = new ArrayList<>();
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= n; i++)
            if (isPrime[i])
                for (int j = i * i; j <= n; j += i)
                    isPrime[j] = false;
        int count = 0;
        for (int i = 2; i <= n; i++)
            if (isPrime[i]) {
                ret.add(i);
                ++count;
            }
        return ret;
    }
    public static boolean isPrime(Long n) {
        if (n == 2) return true;
        List<Integer> primes = countPrimes(23333333);
        for (int i = 0; i < (20); i++) {
            primes.get(i);
        }
        return true;
    }

    public static void main(String[] args) {
        // 生成序列
        int n = 23333333 / 2;
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= n; i++)
            if (isPrime[i])
                for (int j = i * i; j <= n; j += i)
                    isPrime[j] = false;
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                ++count;
            }
        }
        int[] primes = new int[count];
        int idx = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes[idx] = i;
                ++idx;
            }
        }
        int rst = 0;
        for (int i = 2333333; i <= 23333333; i++) {
                int now = i;
//            System.out.println("当前在计算：" + i);
                int cnt = 0;
                for (int ii = 0; ii < primes.length; ii++) {
                    if (now == 1) {
                        break;
                    }
                    int prime = primes[ii];
                    if (prime > 11395) break;
                    if (now % prime == 0) {
                        now /= prime;
                        ++cnt;
                        ii = 0;
                    }
                }
//            System.out.println("计算完成！总共分解为了 " + cnt + " 个质数");
                if (now != 1 ||cnt != 12) {
                    continue;
                }
//            System.out.println("找到啦！！！！！");
                ++rst;

        }
        System.out.println(rst);


    }
}
