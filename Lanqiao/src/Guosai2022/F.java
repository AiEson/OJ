package Guosai2022;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class F {
    boolean flag = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        boolean[] map = new boolean[N + 1];
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
            if (gx.equals(">")) {
                Arrays.fill(map, false);
                for (int ball : R) {
                    map[ball] = true;
                }
            } else if(gx.equals("<")) {
                Arrays.fill(map, false);
                for (int ball : R) {
                    map[ball] = true;
                }
            } else {
                for (int ball : L) {
                    map[ball] = false;
                }
                for (int ball : R) {
                    map[ball] = false;
                }
            }
        }
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            cnt += !map[i] ? 0 : 1;
        }
        System.out.println(cnt);
    }
}
