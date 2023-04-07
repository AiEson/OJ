import java.util.*;

public class 冒泡排序计数 {
    static List<List<Integer>> fullList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nn = sc.nextInt();
        for (int i = 0; i < nn; i++) {
            fullList.clear();
            int n = sc.nextInt();
            int k = sc.nextInt();
//        全排列测试
            fullListMethod(geneArray(n), 0);
            int cnt = 0;
            for (List<Integer> arr : fullList) {
                Integer[] array = arr.toArray(new Integer[arr.size()]);
                if (bSort(array, n) == k) {
                    cnt += 1;
                }
            }
            System.out.println(cnt);
        }

    }
    public static Integer[] geneArray(int n) {
        Integer[] ret = new Integer[n];
        for (int i = 1; i <= n; i++) {
            ret[i - 1] = i;
        }
        return ret;
    }

    public static void fullListMethod(Integer[] arr, int k) {
        if (k == arr.length) {
            List<Integer> list = new ArrayList<>(arr.length);
            Collections.addAll(list, arr);
            fullList.add(list);
        }
        for (int i = k; i < arr.length; i++) {
            swap(arr, i, k);
            fullListMethod(arr, k + 1);
            swap(arr, i, k);
        }
    }
    public static void swap(Integer[] arr, int a, int b) {
//        System.out.println("交换：" + a + " " + b);
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
    public static int bSort(Integer[] A, int n){
//        System.out.println("当前进行冒泡！");
//        System.out.print("初始序列为：");
        int round = 0;
        boolean flag = true;
        while (flag) {
            boolean fl2 = false;
            for (int i = 0; i < n - 1; i++) {
                if (A[i] > A[i + 1]) {
                    swap(A, i, i + 1);
                    fl2 = true;
                }
            }
            if (fl2) {
                round += 1;
                round %= 20100713;
            } else {
                //没有发生交换，数列有序
//                System.out.println("没有发生交换，数列有序");
                flag = false;
            }

        }
//        System.out.println("返回了：" + round);
        return round;
    }
}
