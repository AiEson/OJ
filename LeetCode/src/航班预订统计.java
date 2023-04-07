import java.util.Arrays;

public class 航班预订统计 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().corpFlightBookings(new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}}, 5)));
    }
    static class Solution {
        public int[] corpFlightBookings(int[][] bookings, int n) {
            int[] arr = new int[n];
            for (int[] booking : bookings) {
                for (int i = booking[0] - 1; i < booking[1]; i++) {
                    arr[i] += booking[2];
                }
            }
            return arr;
        }
    }
}
