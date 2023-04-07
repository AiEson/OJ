import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 数组查找及替换 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int in = sc.nextInt();
            if (in % b != 0)
                list.add(in);
        }
        Collections.sort(list);
        for (Integer integer : list) {
            if (integer <= 'Z' && integer >= 'A')
                System.out.print(String.valueOf(Character.toChars(integer)) + " ");
            else
                System.out.print(integer + " ");

        }
    }
}
