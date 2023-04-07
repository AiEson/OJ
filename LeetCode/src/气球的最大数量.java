public class 气球的最大数量 {
    public static void main(String[] args) {
        System.out.println(new Solution().maxNumberOfBalloons("loonbalxballpoon"));
    }
    static class Solution {
        public int maxNumberOfBalloons(String text) {
            int[][] map = new int[123][1];
            for (char c : text.toCharArray()) {
                ++map[c][0];
            }
            int min = Integer.MAX_VALUE;
            String balloon = "balon";
            for (char c : balloon.toCharArray()) {
                min = Math.min(min, (c == 'l' || c == 'o') ? map[c][0] / 2 : map[c][0]);
            }
            return min;
        }
    }
}
