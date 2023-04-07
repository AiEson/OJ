import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 外星游戏 {
    static int N;

    public static int f(int x, int s) {
        return (int) ((((long)N - (long)s) * ((long)N - (long)x) + x * 4) % 7);
    }

    public static int getStringSum(int i) {
        char[] chs = (i + "").toCharArray();
        int sum = 0;
        for (char ch : chs) {
            sum += ch - '0';
        }
        return sum;
    }
    // 获取牌的类型
    public static String getCardType(List<Integer> list) {
        int x = list.get(0); // 111111 s = 6
        int y = list.get(1); // 222222 s = 12
        int z = list.get(2);
        int s = x + y + z;
//        System.out.println("x = " + x + ", x getStringSum = " + getStringSum(x) + ", f(x, getStringSum(x)) = " + f(x, getStringSum(x)));
//        System.out.println("y = " + y + ", y getStringSum = " + getStringSum(y) + ", f(y, getStringSum(y)) = " + f(y, getStringSum(y)));
//        System.out.println("z = " + z + ", z getStringSum = " + getStringSum(z) + ", f(z, getStringSum(z)) = " + f(z, getStringSum(z)));
//        System.out.println("--------------------------------------------------------------");
        if (f(x, getStringSum(x)) == f(y, getStringSum(y)) && f(x, getStringSum(x)) == f(z, getStringSum(z))){
            return "X";
        }
        if (Math.abs(((s % 13) - 7) * 2 - 3) == 5)
            return "Y";
        if ((Math.max(x, Math.max(y, z)) - Math.min(x, Math.min(y, z))) % 5 == (Math.min(x, Math.max(y, z)) * 2) % 3)
            return "Z";
        return "R";
    }

    public static List<List<Integer>> getFullC(List<Integer> list) {
        // 5选3
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                for (int k = j + 1; k < list.size(); k++) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(list.get(i));
                    temp.add(list.get(j));
                    temp.add(list.get(k));
                    result.add(temp);
                }
            }
        }
        return result;
    }

    public static String maxType(String x, String y) {
        if (x.equals("X") || y.equals("X")) return "X";
        if (x.equals("Y") || y.equals("Y")) return "Y";
        if (x.equals("Z") || y.equals("Z")) return "Z";
        return "R";
    }

    public static int getRScore(List<Integer> list) {
        int x = list.get(0);
        int y = list.get(1);
        int z = list.get(2);
        return (x + y + z) % (N / 3);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        List<Integer> kingList = new ArrayList<>();
        // 国王的牌
        for (int i = 0; i < 3; i++) {
            kingList.add(sc.nextInt());
        }
        List<Integer> playerList = new ArrayList<>();
        // 玩家的牌
        for (int i = 0; i < 5; i++) {
            playerList.add(sc.nextInt());
        }
        // 玩家牌的全排列
        List<List<Integer>> playerFullC = getFullC(playerList);
        List<Integer> maxItems = new ArrayList<>(3);
        String maxType = "R";
        for (List<Integer> integers : playerFullC) {
            String nMaxType = getCardType(integers);
//            System.out.println(integers + "\t类型：" + nMaxType);
            if (maxType(nMaxType, maxType).equals(nMaxType)) {
//                System.out.println("上一次的牌型：" + maxType + "，当前牌型：" + nMaxType);
                maxItems.clear();
                maxType = nMaxType;
                maxItems.addAll(integers);
            }
        }
        // 获得国王的牌类型
        String kingType = getCardType(kingList);
//        System.out.println(kingType);
        if (kingType.equals(maxType)) {
            // 牌型相同，计算分数
            int kingScore = getRScore(kingList);
            int playerScore = getRScore(maxItems);
            if (kingScore > playerScore) {
                System.out.println("RUN " + maxType);
            } else if (kingScore == playerScore) {
                // 找最大
                int maxKing = Collections.max(kingList);
                int maxPlayer = Collections.max(maxItems);
                if (maxPlayer > maxKing) {
                    System.out.println(maxType + " " + kingType);
                } else {
                    System.out.println("RUN " + maxType);
                }
            } else {
                System.out.println(maxType + " " + kingType);
            }
        } else {
            // 不相同，通过牌型判断胜负
            if (maxType(maxType, kingType).equals(maxType)) {
                System.out.println(maxType + " " + kingType);
            } else {
                System.out.println("RUN " + maxType);
            }
        }
    }
}
