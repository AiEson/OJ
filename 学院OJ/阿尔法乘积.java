import java.util.Scanner;

public class 阿尔法乘积 {
    public static void main(String[] args) {
        System.out.println(alp(new Scanner(System.in).nextLong()));
    }
    public static long alp(long n) {
        if ((n + "").length() == 1) {
            return n;
        }
        long pwq = 1;
        while (n > 0) {
            long a = n - ((long)(n / 10)) * 10;
            pwq *= a == 0 ? 1 : a;
//            System.out.println(pwq);
            n /= 10;
        }
        return alp(pwq);
    }
}
