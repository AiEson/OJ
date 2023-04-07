import java.math.BigInteger;
import java.util.Scanner;

public class 累加数 {
    public static void main(String[] args) {
        System.out.println(new Solution().isAdditiveNumber(new Scanner(System.in).next()));
    }
    static class Solution {
        public boolean isAdditiveNumber(String num) {
            boolean a = false;
            if (num.length() <= 2) return false;
            //先获取到第一个数。
            BigInteger num1 = null, num2 = null, num3 = null;
            int nPosi = 0;
            for (int i = 1; i <= num.length() / 3; i++) {
                num1 = new BigInteger(num.substring(nPosi, nPosi + i));
//                System.out.println(num1);
                for (int j = 1; j <= num.length() / 3; j++) {

//                    System.out.println("当前的J为：" + j);
                    num2 = new BigInteger(num.substring(nPosi + num1.toString().length(), nPosi + num1.toString().length() + j));
                    BigInteger num12 = num1.add(num2);
                    try {
                        num3 = new BigInteger(num.substring(nPosi + num1.toString().length() + num2.toString().length(), nPosi + num1.toString().length() + num2.toString().length() + num12.toString().length()));
//                        System.out.println("num12 = " + num12 + "  num3 = " + num3);
                        if (num3.equals(num12)) {
                            num1 = num2;
                            num2 = num3;
                            nPosi += num1.toString().length();
                            a = true;
                            --j;
                        } else {
                            continue;
                        }
                    } catch (Exception e) {
                        return a;
                    }

                }
            }






            return false;
        }
    }
}
