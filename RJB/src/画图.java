import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 画图 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), sum = 0;
        List<T> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int zxx = sc.nextInt(), zxy = sc.nextInt(), yxx = sc.nextInt(), yxy = sc.nextInt(), lsize = list.size();
            if (lsize < yxx)
                for (int i1 = 0; i1 < yxx - lsize; i1++)
                    list.add(new T());
//            System.out.println(list.size());
            for (int j = zxx; j < yxx; j++)
                list.get(j).uMax(Math.max(zxy, yxy)).uMin(Math.min(zxy, yxy));
        }
        for (T t : list)
            sum += t.getCnt();
        System.out.println(sum);
    }
    static class T{
        int max = -1, min = Integer.MAX_VALUE;
        public int getCnt() {
            return min == Integer.MAX_VALUE ? 0 : max - min;
        }
        public T uMax(int max) {
            this.max = Math.max(this.max, max);
//            System.out.println(this.max);
            return this;
        }
        public void uMin(int min) {
//            System.out.println(this.min);
            this.min = Math.min(this.min, min);
        }
    }
}
