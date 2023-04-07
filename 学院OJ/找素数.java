import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 找素数 {
    static List<Integer> list = new ArrayList<>();
    static int cnt = 0;
    static int L, R;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        R = sc.nextInt();
        list.add(2);
        int rst = 0;
        if (L <= 2) cnt += 1;
        for (int i = 2; i <= R; i++) {
            judgePrime(i);
        }

        System.out.println(cnt);
    }
    public static void judgePrime(int n) {
        for (int i : list) {
            if (n % i == 0) return;
            if (i * i > n) {
                if (n >= L) cnt += 1;
                list.add(n);
                return;
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
