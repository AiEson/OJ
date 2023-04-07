import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 特殊的质数肋骨 {
    static int deep;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        deep = new Scanner(System.in).nextInt();
        generatePrime(-1, 0);
        for (int item :
                list) {
            System.out.println(item);
        }
    }
    public static void generatePrime(int now, int ndeep){
        //递归停止的条件
        if (deep == ndeep){
            if (isPrime(now)) {
                list.add(now);
                return;
            }
        }
        if (ndeep == 0) {
            //2 3 5 7
            generatePrime(2, 1);
            generatePrime(3, 1);
            generatePrime(5, 1);
            generatePrime(7, 1);
        } else {
            for (int i = 0; i < 10; i++) {
                int n = now * 10 + i;
                if (isPrime(n)) {
                    generatePrime(n, ndeep + 1);
                }
            }
        }

    }
    public static boolean isPrime(int n) {
        if (n == 1) return false;
        if (n == 2) return true;
        for (int i = 2; i < Math.sqrt(n) + 1; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
