import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 删除数组中的0元素 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        CompactIntegers(arr, n);
    }

    public static int CompactIntegers(int arr[],int n) {
        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        for (int i : arr) {
            if (i == 0) ++cnt;
            else list.add(i);
        }
        if (cnt == n) {
            System.out.println((0));
            return 0;
        }
        else {
            System.out.println( n - cnt);
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }

            return n - cnt;
        }
    }
}
