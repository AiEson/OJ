import java.security.KeyPair;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 春哥的日常 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), max = -1;
        CLS[] clss = new CLS[n];
        for (int i = 0; i < n; i++) {
            clss[i] = new CLS(sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(clss);
        int cnt = 0, n_end = -1;
        for (CLS cls : clss) {
            if (n_end <= cls.start) {
                ++cnt;
                n_end = cls.end;
            }
        }
        System.out.println(cnt);
    }
    static class CLS  implements Comparable<CLS>{
        int start, end;
        CLS(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(CLS o) {
            return -(o.end - this.end);
        }

        @Override
        public String toString() {
            return "Start = " + this.start + "\t, end = " + this.end;
        }
    }
}
