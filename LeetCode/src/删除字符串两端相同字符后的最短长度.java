public class 删除字符串两端相同字符后的最短长度 {
    public static void main(String[] args) {
        System.out.println(new Solution().minimumLength("bbbbbbbbbbbbb"));
    }

    static class Solution {
        public int minimumLength(String s) {
            char[] chs = s.toCharArray();
            int head = 0, tail = s.length() - 1;
            while (chs[head] == chs[tail]) {
                if (head > tail) return 0;
                if (head == tail) return 1;
                char c = chs[head];
                while (c == chs[head]) {
                    ++head;
                    if (head > tail) return 0;
                }
                while (c == chs[tail]) --tail;
            }
            return tail - head + 1;
        }
    }
}
