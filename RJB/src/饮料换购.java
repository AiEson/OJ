import java.util.Scanner;

public class 饮料换购 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int mzj = m;
        while(mzj >= 3) {
            int ret = mzj / 3;
            n += ret;
            mzj = (mzj % 3) + ret;
        }
        System.out.println(n + m);
    }
}
// 101 1
// All: 102 Tap: 101
// All: 102 Tap: 101
// All: 102 + 33 Tap: 2 + 33
// All: 135 Tap: 35
// All: 135 + 11 Tap: 2 + 11
// All: 146 Tap: 13
// All: 146 + 4 Tap: 1 + 4
// All: 150 Tap: 5
// All: 152 Tap: 0