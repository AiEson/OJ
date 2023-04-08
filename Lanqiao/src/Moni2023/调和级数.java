package Moni2023;

public class 调和级数 {
    public static void main(String[] args) {
        // 小蓝特别喜欢调和级数 S(n)=1/1+1/2+1/3+1/4+…+1/n 。
        //请问，n 至少为多大时，S(n)>12 ？
        double sum = 0d;
        int n = 1;
        while (sum < 12) {
            sum += (double)1 / (n++);
        }
        System.out.println(n - 1);
        System.out.println(sum);
    }

}
