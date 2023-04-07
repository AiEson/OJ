import java.util.*;

public class 带分数 {
    static int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void main(String[] args) {
        int cnt = 0;
        int n = new Scanner(System.in).nextInt();
        //全排列有了，进行双指针
        List<List<Integer>> permute = permute(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        l1 : for (List<Integer> integers : permute) {

            for (int i = 1; i < 8; i++) {
                for (int j = i + 1; j < 9; j++) {
                    StringBuffer str1 = new StringBuffer();
                    for (Integer integer : integers.subList(0, i)) {
                        str1.append(integer);
                    }
                    double num1 = Integer.parseInt(str1.toString());
                    if (num1 > n) {
                        continue l1;
                    }
                    StringBuffer str2 = new StringBuffer();
                    for (Integer integer : integers.subList(i, j)) {
                        str2.append(integer);
                    }
                    double num2 = Integer.parseInt(str2.toString());
                    StringBuffer str3 = new StringBuffer();
                    for (Integer integer : integers.subList(j, 9)) {
                        str3.append(integer);
                    }
                    double num3 = Integer.parseInt(str3.toString());
                    if (num2 / num3 >= n - 1) continue l1;
                    if ((num1 + (num2 / num3)) == (double) n) {
                        ++cnt;
                    }
                }
            }
            break;
        }
        System.out.println(cnt);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums.length == 0) return ret;
        Deque<Integer> path = new ArrayDeque<>();
        int len = nums.length;
        boolean[] used = new boolean[len];
        dfs(nums, used, 0, path, len, ret);
        return ret;
    }

    private static void dfs(int[] nums, boolean[] used, int deep, Deque<Integer> path, int len, List<List<Integer>> ret) {
        if (deep == len) {
            ret.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) continue;
            used[i] = true;
            path.addLast(nums[i]);
            dfs(nums, used, deep + 1, path, len, ret);
            used[i] = false;
            path.removeLast();
        }
    }

}
