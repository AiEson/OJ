import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 笨小猴 {
    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        String str = new Scanner(System.in).nextLine();
        for (char c : str.toCharArray()) {
            if(map.containsKey(c)){
                map.replace(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int max = -1;
        int min = Integer.MAX_VALUE;
        for (char c : map.keySet()) {
            int val = map.get(c);
            if(max < val) max = val;
            if(min > val) min = val;
        }
        System.out.println(isPrime(max - min) ? ("Lucky Word" + "\n" + (max - min)) : "No Answer" + "\n" + 0);
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
