import java.util.Scanner;

public class 入学考试 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(), M = sc.nextInt();
        int dp[][] = new int[M + 1][T + 1];
        for (int i = 1; i <= M; i++) {
            int t = sc.nextInt(), v = sc.nextInt();
            for (int j = 1; j <= T; j++) {
                if (j >= t)
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - t] + v);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        System.out.println(dp[M][T]);

    }
}
