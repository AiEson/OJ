package Guosai2022;

import java.util.Arrays;
import java.util.Scanner;

public class F2 {
    public static void main(String[] args) {
        boolean flag = false;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        boolean[] map = new boolean[N + 1];
        boolean[] th = new boolean[N + 1];
        Arrays.fill(map, true);
        for (int i = 0; i < M; i++) {
            int K = sc.nextInt();
            int[] L = new int[K], R = new int[K];
            for (int i1 = 0; i1 < K; i1++) {
                L[i1] = sc.nextInt();
            }
            for (int i1 = 0; i1 < K; i1++) {
                R[i1] = sc.nextInt();
            }
            String gx = sc.next();
            if (gx.equals("<")) {
                if (!flag) {
                    Arrays.fill(map, false);
                    for (int i1 : L) {
                        map[i1] = true;
                    }
                    flag = true;
                } else {
                    for (int i1 : R) {
                        map[i1] = false;
                    }
                }
            } else if(gx.equals(">")) {
                if (!flag) {
                    Arrays.fill(map, false);
                    for (int i1 : R) {
                        map[i1] = true;
                    }
                    flag = true;
                } else {
                    for (int i1 : L) {
                        map[i1] = false;
                    }
                }
            } else {
                for (int ball : L) {
                    map[ball] = false;
                    th[ball] = true;
                }
                for (int ball : R) {
                    map[ball] = false;
                    th[ball] = true;
                }
            }
            for (int i1 = 1; i1 < th.length; i1++) {
                if (th[i1]) map[i1] = false;
            }
        }
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            cnt += !map[i] ? 0 : 1;
        }
        System.out.println(cnt);
    }
}
