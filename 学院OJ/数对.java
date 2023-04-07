import java.util.Scanner;

public class 数对 {
    public static void main(String[] args) {
        int a = new Scanner(System.in).nextInt();
        for (int i = 1; i <= a; i++) {
            if (a % i == 0) {
                System.out.println((i + " * " + ((int) a / i) + " = " + a));
            }
        }
    }
}
