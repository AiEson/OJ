import java.util.*;

public class 扑克排序 {
    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = new char[]{'3', '4', '5', '6', '7', '8', '9', 'J', 'Q', 'K', 'A', '2'};
        for (int i = 0; i < chars.length; i++)
            map.put(chars[i], i);
        char[] chars1 = new Scanner(System.in).next().toCharArray();
        Character[] strs = new Character[chars1.length];
        for (int i = 0; i < chars1.length; i++)
            strs[i] = chars1[i];
        Arrays.sort(strs, Comparator.comparingInt(map::get));
        for (Character str : strs)
            System.out.print(str);
    }
}
