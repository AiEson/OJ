import java.util.Scanner;

public class 计算整数因子 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        for(int i = 2; i < Math.sqrt(n) + 1; i++){
            if(n % i == 0 && isPrime(i))System.out.print(i + " ");
        }
    }

    public static boolean isPrime(int n) {
        if(n == 2)return true;
        if(n == 1 || n == 0) return false;
        for(int i = 2; i < Math.sqrt(n) + 1; i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}
