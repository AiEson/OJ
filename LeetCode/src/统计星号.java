public class 统计星号 {
    public static void main(String[] args) {
        System.out.println(new Solution().countAsterisks("l|*e*et|c**o|*de|"));
    }
    static class Solution {
        public int countAsterisks(String s) {
            int ret = 0;
            boolean flag = false;
            for (char c : s.toCharArray()) {
                if (c == '|')
                    flag = !flag;
                if (!flag && c == '*') ++ret;
            }
            return ret;
        }
    }
}
