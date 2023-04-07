import java.util.Scanner;

public class 调和数列问题 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n = sc.nextDouble();
        while(n != 0.00d) {
            // 1/2 + 1/3 ... + 1/(n + 1)
            double sum = 0.00d;
            for(int i = 2; true; i++) {
                sum += 1.00d / (double)i;
                if (sum >= n) {
                    System.out.println(i - 1 + " card(s)");
                    break;
                }
            }
            n = sc.nextDouble();
        }
    }
}