import java.util.*;

public class 约数倍数选卡片 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] fLine = sc.nextLine().split(" ");
        int[] cards = new int[fLine.length];
        for (int i = 0; i < fLine.length; i++) {
            cards[i] = Integer.parseInt(fLine[i]);
        }
        Arrays.sort(cards);
        fLine = sc.nextLine().split(" ");
        int[] choice = new int[fLine.length];
        for (int i = 0; i < fLine.length; i++) {
            choice[i] = Integer.parseInt(fLine[i]);
        }
        Arrays.sort(choice);
        for (int ch : choice) {
            //从小到大进行判定
            List<Integer> cList = new ArrayList<>();
            boolean isAdd = false;
            for (int i : cards) {
                if (!isAdd && i == ch) {
//                    System.out.println("当前的i为：" + i + "；跳过添加------");
                    isAdd = !isAdd;
                } else {
                    cList.add(i);
                }
            }
//            System.out.println("当前选择ch为：" + ch);
            if (canWin(ch, cList)) {
                System.out.println(ch);
                return;
            }
        }
        System.out.println(-1);


    }
    public static boolean canWin(int init, List<Integer> cList) {
        int nCho = init;
        int num = 0;
        for (int i = cList.size() - 1; i >= 0; i--) {
            int n = cList.get(i);
//            System.out.println("当前判定的是：" + n);
            if (canChoose(n, nCho)) {
                //可以选择，那就选择nCho。
//                System.out.println("判定成功！当前选择了：" + n);
                nCho = n;
                num += 1;
                cList.remove(i);
                i = cList.size();
            } else {
//                System.out.println("判定不成功！！！！！！！");
            }
        }
//        System.out.println("遍历完成！选牌次数为: " + num);
        return num % 2 == 0;
    }
    public static boolean canChoose(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        return max % min == 0;
    }
}
