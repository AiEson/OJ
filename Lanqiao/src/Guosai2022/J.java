package Guosai2022;

import java.util.Scanner;

public class J {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int R = sc.nextInt();
        long l = 0;
        for (int i = L; i <= R; i++) {
            if ((i + "").contains("2022")) {
                l += i;
            }
        }
        System.out.println(l);
    }
}
