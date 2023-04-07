package Guosai2022;

import java.io.*;
import java.util.*;

public class C {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>(N);
        int max = N - 1, min = 0;
        for (int i = 0; i < N; i++) {
            map.put(i + 1, i);
        }
        for (int i = 0; i < M; i++) {
            String c = sc.next();
            int num = sc.nextInt();
            if (c.equals("L")) {
                // L
                map.put(num, --min);
            }else {
                // R
                map.put(num, ++max);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(i +1);
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });
        for (int i = 0; i < N; i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
