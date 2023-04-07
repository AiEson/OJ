import java.util.Scanner;

public class 机器人控制之一 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String init = sc.next(), str = sc.next();
        System.out.println(init.charAt(0) == str.charAt(str.length() - 1) ? "YES" : "NO");
    }
}
