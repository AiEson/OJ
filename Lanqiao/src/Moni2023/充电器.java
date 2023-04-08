package Moni2023;

import java.util.Scanner;

public class 充电器 {
    public static void main(String[] args) {
        //问题描述
        //小蓝有一个充电器，可以使用不同的电压和电流充电。
        //给定充电器工作的记录，请计算在这个记录期间总共通过充电传输了多少电能。
        //
        //输入格式
        //输入第一行包含一个整数 n ， 表示记录的条数。
        //接下来 n 行，每行包含一个时刻 T 和两个非负整数 U, ShengSai2023.I，表示在时刻 T 充电电压变为 U（单位伏），
        // 电流变为 ShengSai2023.I（单位A）。最后一行满足 U 和 ShengSai2023.I 均为 0，在前面的行中也可能出现 U、ShengSai2023.I 为 0 的情况。其中时间表示为 HH:MM:SS 的格式，时分秒分别用两位十进制数表示（补前导零）。
        //输入保证时刻依次递增且在 00:00:00 至 23:59:59 的区间内，不用考虑跨过零点充电的情况。
        //
        //输出格式
        //输出一个整数，表示总共通电的电能为多少焦耳，其中 1 焦耳等于 1 伏乘以1 安乘以 1 秒。
        //
        //样例输入
        //    3
        //    12:00:00 12 1
        //    12:01:02 5 2
        //    12:01:10 0 0
        //
        //样例输出
        //    824
        //
        Scanner sc = new Scanner(System.in);
        int samples = sc.nextInt();
        long all = 0;
        int hour = -1, min = -1, sec = -1;
        int befPow = -1, pow = -1;
        while (samples-- != 0) {
            String s = sc.next();
            int U = sc.nextInt();
            int I = sc.nextInt();
            pow = U * I;
            if (befPow == -1) befPow = pow;
            String[] splited = s.split(":");
            for (int i = 0; i < splited.length; i++) {
                if (hour == -1) {
                    hour = Integer.parseInt(splited[0]);min = Integer.parseInt(splited[1]);sec = Integer.parseInt(splited[2]);
                    continue;
                } else {
                    all += (long) (Integer.parseInt(splited[0]) - hour) * 60 * 60 * befPow;
                    all += (long) (Integer.parseInt(splited[1]) - min) * 60 * befPow;
                    all += (long) (Integer.parseInt(splited[2]) - sec) * befPow;
                    hour = Integer.parseInt(splited[0]);min = Integer.parseInt(splited[1]);sec = Integer.parseInt(splited[2]);
                }

                befPow = pow;
            }
        }
        System.out.println(all);
    }
}
