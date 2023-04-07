import java.util.*;

public class 数的划分 {
    public static void main(String[] args) {
        Set<List<Integer>> set = new HashSet<>();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println(try1(sc.nextInt()));
        }
    }
    public static int try1(int n) {
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if ( (int) n / i == 1) {
                cnt++;
            }
        }
        return n - 1 + cnt;
    }

    //放弃了
}
