public class 斐波那契数 {
    public static void main(String[] args) {
        System.out.println(new Solution().fib(7));
        //0 1 1 2 3 5 8 13
    }
    static class Solution {
        public int fib(int n) {
            int a = 0, b = 1;
            while(--n != -1) {
                int c = a + b;
                a = b;
                b = c;
            }
            return a;
        }
    }
}
