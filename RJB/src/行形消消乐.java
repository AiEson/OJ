import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 行形消消乐 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        // 比如说：2#4###4###2#3##3，这是一串可以消去所有数字的字符串。具体顺序为：先消去两个2中间的两个4，再消去两个2，最后消去两个3。
        //
        //再比如说：2#3##2###3，这串字符串则无法消去所有数字，因为虽然数字都成对出现，但是成对出现的两个数字中都夹着其他的数字。
        // 判断是否可以消去所有数字
        Map<Character, Integer> map = new HashMap<>(10);
        for (char c : str.toCharArray()) {
            if (c == '#') continue;
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                System.out.println("False");
                return;
            }
        }
        System.out.println("True");
    }
}
