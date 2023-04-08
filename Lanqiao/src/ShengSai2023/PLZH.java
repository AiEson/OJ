package ShengSai2023;

import java.util.ArrayList;
import java.util.List;

public class PLZH {

    static List<List<Integer>> allList = new ArrayList<>();
    public static void main(String[] args) {
        dfs(new int[]{1,2,3,4,5}, -1, new ArrayList<>());
        System.out.println(allList);
    }
    public static void dfs(int[] A, int i, List<Integer> choosed) {
        System.out.println(i + " " + choosed);
        if (i == A.length - 1) {
            if (choosed.size() == 3)
                allList.add(new ArrayList<>(choosed));
            return;
        }
        // choose
        choosed.add(A[i + 1]);
        dfs(A, i + 1, choosed);
        choosed.remove(choosed.size() - 1);
        dfs(A, i + 1, choosed);
    }
}
