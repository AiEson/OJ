import com.sun.jdi.IntegerValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 检测正方形 {
    public static void main(String[] args) {
        DetectSquares obj = new DetectSquares();
        add(obj, 3, 10);
        add(obj, 11, 2);
        add(obj, 3, 2);
        System.out.println(obj.count(new int[]{11, 10}));
        System.out.println(obj.count(new int[]{14, 8}));

        add(obj, 11, 2);
        System.out.println(obj.count(new int[]{11, 10}));

    }
    public static void add(DetectSquares detectSquares, int a, int b) {
        detectSquares.add(new int[]{a, b});
    }
    static class DetectSquares {
        static List<int[]> points = new ArrayList<>();

        public void add(int[] point) {
            points.add(point);
        }

        private static boolean contains(int x, int y) {
            for (int[] point : points)
                if (point[0] == x && point[1] == y) return true;
            return false;
        }

        public int count(int[] point) {
            int cnt = 0;
            //先从同 X 开始确定：
            for (int i = 0; i < points.size(); i++) {
                int[] nPoi = points.get(i);
                if (nPoi[0] == point[0]) {
                    if (nPoi[1] == point[1]) return 0;
                    //x 相同，判定Y的差值
                    int diff = Math.abs(nPoi[1] - point[1]);
                    if (nPoi[1] > point[1]){
                        // point在左下
                        if (contains(point[0] + diff, point[1])
                         && contains(point[0] + diff, point[1] + diff))
                            ++cnt;
                        // point在右下
                        if (contains(point[0] - diff, point[1])
                                && contains(point[0] - diff, point[1] + diff))
                            ++cnt;
                    } else {
                        // point在左上
                        if (contains(point[0] + diff, point[1])
                                && contains(point[0] + diff, point[1] - diff))
                            ++cnt;
                        // 在右上
                        if (contains(point[0] - diff, point[1])
                                && contains(point[0] - diff, point[1] - diff))
                            ++cnt;
                    }

                }

            }
            return cnt;
        }
    }
/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */
}
