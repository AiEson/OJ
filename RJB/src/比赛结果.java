import java.util.*;

public class 比赛结果 {
    static Set<String> set = new HashSet<>();
    static int n;
    static int cnt = 0;
    public static long jc(int n) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= i;
        }
        return ans;
    }

    public static void main(String[] args) {
        // 对于有 a1, a2 两个人进行赛，最终可能有三种结果，a1,a2并列第一，a1 获得第一名，a2第二， a1 第二 ，a2 第一。
        //
        //对于 n 个人的比赛，最终可能的结果有多少种。
        //
        //输入
        //输入一个整数 n (1 <= n <= 20)
        //
        //输出
        //输出一个整数，表示最终可能的结果的种数。
        //
        Scanner sc = new Scanner(System.in);

        // 通过set记录所有可能的名次
        n = sc.nextInt();
//        System.out.println(set);
        List<Integer> list = new ArrayList<>();
        dfs(list);
        System.out.println(cnt  +1);
    }

    private static void dfs(List<Integer> nStr) {
//        if (nStr.length() != 0 && nStr.charAt(0) != '1') return;
        if (nStr.size() == n) {
//            System.out.println(nStr);
            // 判断列表中是否全为同一个数字组成
            boolean flag = true;
            for (int i = 1; i < nStr.size(); i++) {
                if (nStr.get(i) != nStr.get(0)) {
                    flag = false;
                    break;
                }
            }
            if (!flag)
                cnt++;
            return;

        }
        for (int i = 1; i <= (n); i++) {
            nStr.add(i);
            dfs(nStr);
            nStr.remove(nStr.size() - 1);
        }
    }
}
