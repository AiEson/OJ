import java.util.Scanner;

public class 字符删除 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char ch = sc.next().charAt(0);
        for (char c : str.toCharArray()) {
            if (ch != c) System.out.print(c);
        }
    }
}
