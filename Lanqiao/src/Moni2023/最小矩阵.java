package Moni2023;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 最小矩阵 {
    public static void main(String[] args) {
        //问题描述
        //小蓝有一个 100 行 100 列的矩阵，矩阵的左上角为 1。其它每个位置正好比其左边的数大 2，比其上边的数大 1 。
        //例如，第 1 行第 2 列为 3，第 2 行第 2 列 为 4，第 10 行第 20 列为 48。
        //小蓝想在矩阵中找到一个由连续的若干行、连续的若干列组成的子矩阵，
        // 使得其和为 2022，请问这个子矩阵中至少包含多少个元素（即子矩阵的行数和列数的乘积）
        int[][] mat = geneMat(100);
//        System.out.println(Arrays.deepToString(mat));
        System.out.println(judge(new Point(0,0), new Point(1,1), mat));
        int nn = 100, rst = Integer.MAX_VALUE;
        for (int x1 = 0; x1 < nn - 1; x1++) {
            for (int y1 = 0; y1 < nn - 1; y1++) {
                for (int x2 = x1 + 1; x2 < nn; x2++) {
                    for (int y2 = y1 + 1; y2 < nn; y2++) {
                        rst = Math.min(judge(new Point(x1, y1), new Point(x2, y2), mat), rst);
                    }
                }
            }
        }
        System.out.println(rst);
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(value -> value.x));
    }
    static class Point{
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int judge(Point p1, Point p2, int[][] mat) {
        // 保证 p1的 x y 都小于 p2 的
        int sum = 0;
        for (int y = p1.y; y <= (p2.y ); y++) {
            for (int x = p1.x; x <= (p2.x ); x++) {
//                System.out.println(x + " " + y);
                sum += mat[x][y];
            }
        }
//        System.out.println(sum);
        return sum == 2022 ? (p2.y - p1.y + 1) * (p2.x - p1.x + 1) : Integer.MAX_VALUE;
    }
    public static int[][] geneMat(int n) {
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            if (i == 0) mat[0][0] = 1;
            else mat[i][0] = mat[i - 1][0] + 1;
            for (int j = 1; j < n; j++) {
                mat[i][j] = mat[i][j - 1] + 2;
            }
        }
        return mat;
    }
}
