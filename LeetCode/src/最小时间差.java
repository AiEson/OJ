import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 最小时间差 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("00:00");
        list.add("23:59");
        System.out.println(new Solution().findMinDifference(list));
    }
    static class Solution {
        public int findMinDifference(List<String> timePoints) {
            int[] list = new int[timePoints.size()];
            if (timePoints.size() >= 1440 || timePoints.size() <= 1) return 0;
            for (int i = 0; i < timePoints.size(); i++) {
                String timePoint  = timePoints.get(i);
                String[] time = timePoint.split(":");
                int left = Integer.parseInt(time[0]);
                int right = Integer.parseInt(time[1]);
                list[i] = (left * 60 + right);
            }
            Arrays.sort(list);
            int min = list[0] + 1440 - list[list.length - 1];
            //滑动窗口
            for (int i = 0; i < list.length - 1; i++) {
                min = Math.min(list[i + 1] - list[i], min);
            }
            return min;
        }
    }

}
