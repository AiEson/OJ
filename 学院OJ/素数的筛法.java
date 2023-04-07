import java.util.Scanner;

public class 素数的筛法 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        int[] arr = new int[n + 1];
        int[] p = new int[n + 1];
        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) p[++cnt] = i;
            for (int j = 1; j <= cnt && i * p[j] <= n; j++) {
                arr[i * p[j]] = -1;
                if (i % p[j] == 0) break;
            }
        }
        for (int i = 1; i <= cnt; i++) {
            System.out.print(p[i] + " ");
        }
    }
}
