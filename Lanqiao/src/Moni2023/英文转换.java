package Moni2023;

import java.util.Scanner;

public class 英文转换 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //问题描述
        //输入一个由小写英文字母组成的字符串，请将其中的元音字母（a, e, i, o, u)转换成大写，其它字母仍然保持小写。
        //
        //输入格式
        //输入一行包含一个字符串。
        //
        //输出格式
        //输出转换后的字符串。
        //
        //样例输入
        //    lanqiao
        //
        //样例输出
        //    lAnqIAO
        String in = sc.next();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < in.toCharArray().length; i++) {
            char c = in.charAt(i);
            if (c == 'a' ||c == 'e' ||c == 'i' ||c == 'o' ||c == 'u') {
                sb.append(String.valueOf(c).toUpperCase());
            }
            else sb.append(c);
        }
        System.out.println(sb);
    }
}
