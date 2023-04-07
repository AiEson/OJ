import java.util.HashMap;
import java.util.Map;

public class 面试题2出现的次数 {
    public static void main(String[] args) {
        System.out.println(new Solution().numberOf2sInRange(222));
        // 10 1
        // 100 20
        // 1000 300
    }
    static class Solution {
        public int numberOf2sInRange(int n) {
            int sum = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(10, 1);
            map.put(100, 20);

            int base_ws = (int) Math.log10(n);
            int base_num = (int) ((base_ws - 1) * Math.pow(10, base_ws - 2));
            System.out.println(base_num);
            int iter_ws = (int) Math.pow(10, base_ws - 1);
            int i = 0;
            while (i + 2*iter_ws < n) {
                if (base_num == 0) break;
                i += iter_ws;
                System.out.println("Not I = " + i);
                // 100 20
                // 200 41
                // 300 160
                // 400 180
                // 900 280
                if (i / iter_ws == 3) {
                    sum += 6 * base_num;
                    System.out.println("Added 2: " + sum);
                }
                else {
                    sum += base_num;
                    System.out.println("Not Added 2: " + sum);
                }
            }
//            i -= iter_ws;
            System.out.println("Now i = \t\t" + i);
            while (i <= n) {
                String s = i+"";
//                System.out.println(s);
                for (char c : s.toCharArray()) {
                    if (c == '2') ++sum;
                }
//                System.out.println((sum + "aaaaaaa"));
                i++;
            }
            System.out.println(sum);
            return sum;
        }
    }
}
