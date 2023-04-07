public class 三除数 {
    public static void main(String[] args) {
        System.out.println(new Solution().isThree(9));
    }
    static class Solution {
        public boolean isThree(int n) {
            if (n <= 3) return false;
            boolean flag = false;

            for (int i = 2; i < n; i++) {
                System.out.println(i);
                if (n % i == 0) {
                    if (flag) return false;
                    flag = true;
                }
            }
            return flag;
        }
    }
}
