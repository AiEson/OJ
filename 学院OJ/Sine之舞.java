import java.util.Scanner;

public class Sine之舞 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        System.out.println(S(n));
    }
    public static String A(int now, int n) {
        //An=sin(1–sin(2+sin(3–sin(4+...sin(n))...)
        StringBuffer stringBuffer = new StringBuffer("sin(");
        if (now == n) {
            return stringBuffer.append(n).append(")").toString();
        } else {
            return stringBuffer.append(now).append((now % 2 == 0 ? "+" : "-")).append(A(now + 1, n)).append(")").toString();
        }
    }
    public static String S(int n) {
        //Sn=(...(A1+n)A2+n-1)A3+...+2)An+1
        //S1=(A1+1)
        //S3 = (( A1 +3) A2 +2) A3 +1
        //S3 = (S1 S2)sin(1–sin(2+sin(3)))+1
        //((sin(1)+3)sin(1–sin(2))+2)sin(1–sin(2+sin(3)))+1
        StringBuffer stringBuffer = new StringBuffer();
        for (int now = 1; now < n; now++) {
            stringBuffer.append("(");
        }
        for (int now = 1; now <= n; now++) {
            stringBuffer.append(A(1, now)).append("+").append(n - now + 1);
            if (now <= n - 1) stringBuffer.append(")");
        }
        return stringBuffer.toString();
    }
}
