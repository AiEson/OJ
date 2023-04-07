import java.util.Scanner;

public class 进制转换 {
    public static void main(String[] args) {
        Main.main(new String[]{});
    }
    public static class Main{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                String str = sc.next().toUpperCase();
                long rst = 0;
                int a = 0;
                for (int length = str.length() - 1; length >= 2; length--) {
                    rst += convert(str.charAt(length), a);
//                    System.out.println(str.charAt(length));
                    ++a;
                }
                System.out.println(rst);
            }
        }
        private static int map(char c){
            if (c >= 'A') {
                return (c - 'A') + 10;
            }
            return Integer.parseInt(String.valueOf(c));
        }
        private static int convert(char c, int wei){
            return (int) (Math.pow(16, wei) * map(c));
        }
    }


    public static void res(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String str = sc.next().substring(2).toLowerCase();
//            System.out.println(str);
            char[] chars = str.toCharArray();
            int re = 0;
            for (int j = 3; j >= 0; j--) {
                if (chars[j] >='a' && chars[j] <= 'f') {
                    re += (chars[j] - 87)* Math.pow(16,3 - j);
                }else {
                    re += (chars[j] - 48) * Math.pow(16, 3 - j);
                }
            }
            System.out.println(re);
        }
    }
}