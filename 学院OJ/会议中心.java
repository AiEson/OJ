import java.util.*;

public class 会议中心 {
    static Map <Integer, int[]> nodeMap;
    static int maxLen = - Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        nodeMap = new HashMap<>();
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int[] cont = new int[2];
            cont[0] = sc.nextInt();
            cont[1] = sc.nextInt();
            nodeMap.put(i + 1, cont);
        }
        for(int i = 1; i <= N; i++) {
            List<Integer> test = new ArrayList<>();
            test.add(i);
            dfs(i, N + 1, test);
        }
        List<String> rstList = new ArrayList<>();
        for (List<Integer> list : rst) {

            if (list.size() == maxLen) {
                StringBuffer str = new StringBuffer();
                for (Integer integer : list) {
                    str.append(integer + " ");
//                    System.out.print(integer + " ");
                }
                rstList.add(str.toString());
            }
        }
        System.out.println(maxLen);
        Collections.sort(rstList);
        System.out.println(rstList.get(0));
    }
    static List<List<Integer>> rst = new ArrayList<>();
    //递归发起深度搜索
    public static void dfs(int n, int to, List<Integer> list) {
        if (n == to) {
            if (list.size() >= maxLen) {
                rst.add(list);
                maxLen = Math.max(maxLen, list.size());
            }

        } else {
            //获取上一家公司的最后使用时间
            int foreUseTime = nodeMap.get(list.get(list.size() - 1))[1];
//            System.out.println("上一家公司的最后使用时间：" + foreUseTime + "\t这家公司为：" + list.get(list.size() - 1));
            int beginUseTime = nodeMap.get(n)[0];
//            System.out.println("下一家公司的开始使用：" + beginUseTime + "\t下一家公司为：" + n);
            if (beginUseTime > foreUseTime) {
                //时间不冲突，list加入
//                System.out.println("时间不冲突，list加入: " + n);
                List<Integer> list1 = new ArrayList<>();
                for (Integer integer : list) {
                    list1.add(integer);
                }
                dfs(n + 1, to, list1);
                list.add(n);
            }
            dfs(n + 1, to, list);
        }
    }

}
