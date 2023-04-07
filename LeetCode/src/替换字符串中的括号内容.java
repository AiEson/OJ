import java.util.*;

public class 替换字符串中的括号内容 {
    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("name");
        list1.add("Bob");
        List<String> list2 = new ArrayList<>();
        list2.add("age");
        list2.add("12");
        list.add(list1);
        list.add(list2);
        System.out.println(new Solution().evaluate("(name)is(age)y(123)earsold", list));
    }
    static class Solution {
        public String evaluate(String s, List<List<String>> knowledge) {
            Map<String, String> map = new HashMap<>(knowledge.size());
            for (List<String> strings : knowledge)
                map.put(strings.get(0),strings.get(1));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    int j = i + 1;
                    while (s.charAt(j) != ')') ++j;
                    String key = s.substring(i + 1, j);
                    sb.append(map.getOrDefault(key, "?"));
                    i = j;
                }
                else {
                    sb.append(s.charAt(i));
                }
            }
            return sb.toString();
        }
    }
}
