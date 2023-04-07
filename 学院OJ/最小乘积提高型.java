import java.util.*;

public class 最小乘积提高型 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (--t != -1) {
            int n = sc.nextInt();
            List<Integer> l1 = new ArrayList<>(n);
            List<Integer> l2 = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                l1.add(sc.nextInt());
            }
            for (int i = 0; i < n; i++) {
                l2.add(sc.nextInt());
            }
            Collections.sort(l1);
            Collections.sort(l2, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            int rst = 0;
            for (int i = 0; i < n; i++) {
                rst += l1.get(i) * l2.get(i);
            }
            System.out.println(rst);

        }
    }
}
