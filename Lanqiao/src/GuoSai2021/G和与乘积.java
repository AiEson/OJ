package GuoSai2021;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class G和与乘积 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), cnt = 0;
        int[] arrs = new int[n];
        for (int i = 0; i < n; i++) {
            arrs[i] = sc.nextInt();
        }
         BigInteger[] bigIntegers = new BigInteger[n + 1];
        long[] qianzhuihe = new long[n + 1];
        qianzhuihe[0] = 0;
        bigIntegers[0] = BigInteger.valueOf(1);
        for (int i = 1; i <= n; i++) {
            bigIntegers[i] = bigIntegers[i - 1].multiply(BigInteger.valueOf(arrs[i - 1]));
            qianzhuihe[i] = qianzhuihe[i - 1] + arrs[i - 1];
        }
//        System.out.println(Arrays.toString(bigIntegers));
//        System.out.println(Arrays.toString(qianzhuihe));
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                // 先获取前缀和
                long sum = qianzhuihe[j] - qianzhuihe[i - 1];
//                System.out.println("qianzhuihe[" + j + "] - qianzhuihe[" + i + "] = " + sum);
                // 获取前缀积
                long ji = Long.parseLong(bigIntegers[j].divide(bigIntegers[i - 1]).toString());
                if (sum == ji) {
                    ++cnt;
                    System.out.println(i + " " + j);
//                    System.out.println(j + " " + i + " : he" + sum + "  ji" + ji);
                }

            }
        }
        System.out.println(cnt + arrs.length);


    }
}
