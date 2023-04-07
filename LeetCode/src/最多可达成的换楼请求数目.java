import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 最多可达成的换楼请求数目 {
    public static void main(String[] args) {
        System.out.println(new Solution().maximumRequests(4, new int[][]{{0,3},{1,0},{0,0},{3,3},{3,0},{2,2},{1,1},{2,3},{0,3}}));
    }
    static class Solution {
        public int maximumRequests(int n, int[][] requests) {
            int cnt = 0;
            // 贪心尝试
            int[] arr = new int[n];
            boolean changed = true;
            int same = 0;
            List<int[]> list = new ArrayList<>();

            for (int i = 0; i < requests.length; i++) {
                if (requests[i][0] == requests[i][1]) {
                    ++same;
                    continue;
                }
                list.add(requests[i]);

            }
            int[][] ints = new int[list.size()][2];
            for (int i = 0; i < list.size(); i++) {
                ints[i] = list.get(i);
            }
            for (int i = 0; i < ints.length; i++) {
                System.out.println("=========" + i + "============");
                cnt = Math.max(dfs(i, 1, ints, new int[n]), cnt);
            }
            System.out.println(same);
            return cnt + same;
        }

        private int dfs(int now, int deep, int[][] requests, int[] arr) {
            System.out.println("当前DEEP 为 " + deep + "DFS开始前：" + Arrays.deepToString(requests));
            int[] nowArr = requests[now];
            int loss = nowArr[0];
            int add = nowArr[1];
            --arr[loss];
            ++arr[add];
            requests[now] = new int[]{-1, -1};
            System.out.println("当前arr为：" + Arrays.toString(arr) + "\t当前的request为：" + Arrays.deepToString(requests));
            int ret = -Integer.MAX_VALUE;
            if (isValid(arr, 0, 0)) ret = deep;
            // 进行剪枝操作

            // 想要对损失的进行补充，则循环匹配可以补充的
            boolean found = false;
            for (int i = 0; i < requests.length; i++) {
                int[] request = requests[i];
                if (request[0]!= -1 && request[1] == loss) {
                    ret = Math.max(dfs(i, deep + 1, requests, arr), ret);
                    found = true;
                }
            }
            requests[now] = nowArr;
            ++arr[loss];
            --arr[add];
//            System.out.println("DFS开始后——：" + Arrays.deepToString(requests));
            if (!found) System.out.println("找不到啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊\t" + deep);
            if (found)
                return ret;
            else if (isValid(arr, loss, add)) return deep;
            else return 0;
        }
        private boolean isValid(int[] arr, int loss, int add) {
            --arr[loss];
            ++arr[add];
            System.out.println("正在检测：\t" + Arrays.toString(arr));
            for (int i : arr)
                if (i != 0) {
                    System.out.println("检测失败！死在了 " + i);
                    return false;
                }
            System.out.println("检测成功！");
            ++arr[loss];
            --arr[add];
            return true;
        }
    }
}
