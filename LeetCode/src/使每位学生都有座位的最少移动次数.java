import java.util.Arrays;

public class 使每位学生都有座位的最少移动次数 {
    public static void main(String[] args) {
        System.out.println(new Solution().minMovesToSeat(new int[]{3,1,5}, new int[]{2, 7, 4}));
    }
    static class Solution {
        public int minMovesToSeat(int[] seats, int[] students) {
            int sum = 0;
            Arrays.sort(seats);
            Arrays.sort(students);
            for (int i = 0; i < seats.length; i++) {
                sum += Math.abs(seats[i] - students[i]);
            }
            return sum;
        }
    }
}
