package Moni2023;

import java.util.Scanner;

public class 核酸日期 {
    public static void main(String[] args) {
        //如果周一做核酸，周二显示核酸天数为 1 天，周三显示 2 天，以此类推，周六显示 5 天，周日显示 6 天。
        //小蓝在某一天做了一次核酸，请问他的核酸显示为几天。已知做核酸和查看核酸不是在同一天，而且相差不超过 6 天（显示的数为 1 到 6 之间的数）。
        //
        //输入格式
        //输入第一行包含一个整数 s ，表示小蓝做核酸是周几。 s 为 1 到 6 依次表示周一到周六，s 为 7 表示周日。
        //第二行包含一个整数 t ，表示查看核酸是周几。 t 为 1 到 6 依次表示周一到周六，t 为 7 表示周日。
        //
        //输出格式
        //输出一行包含一个整数，表示答案
        Scanner sc = new Scanner(System.in);
        int zuo = sc.nextInt();
        int cha = sc.nextInt();
        System.out.println(zuo > cha ? (7 - (zuo - cha)) : cha - zuo);
    }
}
