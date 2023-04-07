import java.util.Scanner;

public class 消失的数字 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), sum = 0;
        for (int i = 0; i < n; i++) {sum += sc.nextInt();}
        System.out.println(Math.abs(sum - ((++n * (n + 1)) / 2)));
    }
}
