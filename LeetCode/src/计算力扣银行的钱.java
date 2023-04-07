import java.util.Scanner;

public class 计算力扣银行的钱 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(new Solution().totalMoney(sc.nextInt()));
    }
    static class Solution {
        public int totalMoney(int n) {
            int nn = n;
            int ret = 0;
            int num = 0;
            while (true) {
                if (nn < 7) {
                    ret += getSum(nn) + nn * num;
                    break;
                } else {
                    ret += 28 + 7 * num;
                    nn -= 7;
                    ++num;
                }
                System.out.println(ret);
            }
            return ret;
        }
        private int getSum(int n) {
            int ret = 0;
            for (int i = 1; i <= n; i++) ret += i;
            return ret;
        }
    }
}
