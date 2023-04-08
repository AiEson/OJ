package Moni2023;

public class 最小数 {
    public static void main(String[] args) {
        // 问题描述：请找到一个大于 2022 的最小数，这个数转换成十六进制之后，所有的数位（不含前导 0）都为字母（ShengSai2023.A 到 ShengSai2023.F）。
        //        请将这个数的十进制形式作为答案提交。
        int shu = 2022;
        System.out.println((int) '1');
        System.out.println((int) '9');
        l1: while (shu++ > 0) {
//            System.out.println(Integer.toHexString(shu));
            System.out.println(Integer.toHexString(shu));
            for (char c : Integer.toHexString(shu).toCharArray()) {
                if (c <= '9' && c >= '0') continue l1;

            }
            System.out.println(shu);
            break l1;
        }
    }
}
