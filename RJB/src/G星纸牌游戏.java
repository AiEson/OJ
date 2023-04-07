import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class G星纸牌游戏 {
    static int[] kingMax = new int[3], myMax = new int[3];
    static int N;
    public static List<List<Integer>> generateC(List<Integer> list) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                for (int k = j + 1; k < list.size(); k++) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(list.get(i));
                    tmp.add(list.get(j));
                    tmp.add(list.get(k));
                    ret.add(tmp);
                }
            }
        }
        return ret;
    }
    public static int Xf(int x) {
        return ((x+2)*4)%(N-5);
    }
    // 无牌型得分
    public static int noCardTypeScore(int[] arr) {
        return (arr[0] + arr[1] + arr[2]) % (N / 3);
    }

    public static String getType(List<Integer> list) {
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++)
            arr[i] = list.get(i);
        Arrays.sort(arr);
        int[] ret = new int[3];
        for (int i = 0; i < 3; i++)
            ret[i] = Xf(arr[i]);
        Arrays.sort(ret);
        System.out.println(Arrays.toString(ret));
        if (ret[0] + 1 == ret[1] && ret[1] + 1 == ret[2])
            return "X";
        if ((arr[0] + arr[1] + arr[2]) % 13 - 7 == 0)
            return "Y";
        if ((arr[2] - arr[0]) % 5 == (arr[1] * 2) % 3)
            return "Z";
        return "R";
    }

    public static String getMax(String type1, String type2) {
        // X > Y > Z > R
//        System.out.println( type1 + " " + type2);
        if (type1 == "X" || type2 == "X") return "X";
        if (type1 == "Y" || type2 == "Y") return "Y";
        if (type1 == "Z" || type2 == "Z") return "Z";
        return "R";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        // 输入5张牌，代表国王的牌
        List<Integer> list = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            list.add(sc.nextInt());
        }
        // 生成国王牌所有的组合
        List<List<Integer>> kingList = generateC(list);
        // 生成小王的牌
        List<Integer> list2 = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            list2.add(sc.nextInt());
        }
        // 生成小王的牌所有的组合
        List<List<Integer>> mylist = generateC(list2);
        // 获取所有国王牌的可能类型，
        String maxKingType = "R";
        for (List<Integer> integers : kingList) {
            String type = getType(integers);
            System.out.println(type);

            String maxType = getMax(maxKingType, type);
            // 如果变了，更新最大
            if (!maxType.equals(maxKingType)) {
                maxKingType = maxType;
                for (int i = 0; i < integers.size(); i++) {
                    kingMax[i] = integers.get(i);
                }
            }
            if (maxKingType.equals("X")) break;
        }
        System.out.println("国王牌的最大牌型为：" + maxKingType);
        // 获取所有小王牌的可能类型，
        String maxMyType = "R";
        for (List<Integer> integers : mylist) {
            String type = getType(integers);
            String maxType = getMax(maxMyType, type);
            // 如果变了，更新最大
            if (!maxType.equals(maxMyType)) {
                maxMyType = maxType;
                for (int i = 0; i < integers.size(); i++) {
                    myMax[i] = integers.get(i);
                }
            }
        }
        System.out.println("小王牌的最大牌型为：" + maxMyType);
        // 判断谁的牌型大
        if (maxMyType.equals(maxKingType)) {
            System.out.println("牌型相同");
            // 输出元素
            for (int i = 0; i < 3; i++) {
                System.out.print(myMax[i] + " ");
            }
            System.out.println();
            for (int i = 0; i < 3; i++) {
                System.out.print(kingMax[i] + " ");
            }
            System.out.println();
            // 按照无牌型比较，获得分数
            int myScore = noCardTypeScore(myMax);
            int kingScore = noCardTypeScore(kingMax);
            if (myScore > kingScore) {
                System.out.println("YES");
            } else if (myScore == kingScore) {
                // 比较最大的元素
                Arrays.sort(myMax);
                Arrays.sort(kingMax);
                if (myMax[2] > kingMax[2]) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                System.out.println("NO");
            }
        } else {
            // 比较牌型
            if (getMax(maxMyType, maxKingType).equals(maxMyType)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }
}
