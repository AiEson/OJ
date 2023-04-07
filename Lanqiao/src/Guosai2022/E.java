package Guosai2022;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class E {
    static int cnt = 0;
    static int n;
    static Map<String, String> csm;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        csm = new HashMap<>(m);
        for (int i = 0; i < m; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            if (x1 + y1 < x2 + y2)
                csm.put(x1 + " " + y1, x2 + " " + y2);
            else
                csm.put(x2 + " " + y2, x1 + " " + y1);
        }
        int totalSc = 0;
        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= n; y++) {
                totalSc += dfs(x, y, 0);
            }
        }
        System.out.printf("%.2f", (double)totalSc / (n * n));
    }
    private static int dfs(int x, int y, int sc){
        if (x == n && y == n) return sc;
        if (x == n) {
            if (csm.containsKey(x + " " + y)) {
                String[] a = csm.get(x + " " + y).split(" ");
                return Math.min(dfs(x, y + 1, sc+1), dfs(Integer.parseInt(a[0])
                , Integer.parseInt(a[1]), sc+ 1));
            } else {
                return dfs(x, y + 1, sc+1);
            }
        } else if (y == n) {
            if (csm.containsKey(x + " " + y)) {
                String[] a = csm.get(x + " " + y).split(" ");
                return Math.min(dfs(x + 1, y, sc+1), dfs(Integer.parseInt(a[0])
                        , Integer.parseInt(a[1]), sc+ 1));
            } else {
                return dfs(x + 1, y, sc+1);
            }
        } else {
            if (csm.containsKey(x + " " + y)) {
                String[] a = csm.get(x + " " + y).split(" ");
                return Math.min(Math.min(dfs(x + 1, y, sc+1), dfs(Integer.parseInt(a[0])
                        , Integer.parseInt(a[1]), sc+ 1))
                , dfs(x, y + 1, sc+1));
            } else {
                return Math.min(dfs(x + 1, y, sc+1), dfs(x, y + 1, sc + 1));
            }
        }
    }
}
