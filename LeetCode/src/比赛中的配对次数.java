public class 比赛中的配对次数 {
    public static void main(String[] args) {
        System.out.println(new Solution().numberOfMatches(7));
    }
    static class Solution {
        public int numberOfMatches(int n) {
            return n - 1;
        }
    }
}
