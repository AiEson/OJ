import java.util.Scanner;

public class 合并石子堆 {
    public static void main(String[] args) {
        System.out.println(ovo());
//        String nums = "123.123";
    }
    public static String ovo() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int sum = 0, max = -1;
        for (int i = 0; i < n; i++) {
            int in = sc.nextInt();
            sum += in;
            max = Math.max(max, in);
        }
        int div = -1;
        if (sum % k == 0) div = sum / k;
        else return "NO";
        if (div <= max) return "YES";
        else return "NO";
    }

}
