import java.util.Scanner;

public class TWO的幂次方 {
    public static void main(String[] args) {
        long n = new Scanner(System.in).nextLong();
        if (n == 0) {
            System.out.println("NO");
        }
        while (n != 1) {
            if (n % 2 == 1) {
                System.out.println("NO");
                return;
            }
            n /= 2;
        }
        System.out.println("YES");
    }
}
