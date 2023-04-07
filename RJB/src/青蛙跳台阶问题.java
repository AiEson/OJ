import java.util.Scanner;

public class 青蛙跳台阶问题 {
    // 有一只青蛙，跳到了一排台阶台(阶数为n)前面，小青蛙起点是地面，它需要跳到台阶顶部去上面的池塘。
    //
    //现在因为青蛙控制不好自己的弹跳力度，所以有可能它一次跳跃一个或者两个台阶，概率为p1 和 p2。在某个台阶上面有蛇在上面休息，所以绝对不能去到这台阶。求能安全到达的概率(即没有跳到有蛇的台阶上面)。

    public static double dfs(int cur, int n, double p1, double p2, int dangIdx) {
        if (cur == n) {
            return 1;
        }
        if (cur > n) return 0;
        if (dangIdx == cur) return 0;
        return p1 * dfs(cur + 1, n, p1, p2, dangIdx) + p2 * dfs(cur + 2, n, p1, p2, dangIdx);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double a1 = sc.nextDouble();
        double a2 = sc.nextDouble();
        int dangIdx = sc.nextInt();
        double ans = dfs(0, n - 1, a1, a2, dangIdx);
        System.out.println(ans);

    }
}
