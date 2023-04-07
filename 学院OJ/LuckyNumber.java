import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LuckyNumber {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Boolean> listBooleans = new ArrayList<>();
        List<Integer> luckyNums = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int from = sc.nextInt();
        int to = sc.nextInt();
        luckyNums.add(1);
        for(int i = 1; i <= to; i++){
            list.add(i);
            listBooleans.add(true);
        }
        int num = getNextLNum(list, luckyNums);
        l1 : while(num != -1)
        {
            for(int i = list.size() - 1; i >= 0; i--){
                if((i + 1) % num == 0){
                    list.remove(i);
                }
            }
            num = getNextLNum(list, luckyNums);
            luckyNums.add(num);
        }
        StringBuffer stringBuffer = new StringBuffer();
        int cnt = 0;
        for(int i : list) {
            if (i > to) break;
            if (i > from) {
                if(i < to) cnt += 1;
            }
        }
        System.out.println(cnt);
    }
    public static int getNextLNum(List<Integer> list, List<Integer> luckyNums){
        for(int i = 0; i < list.size(); i++){
            int a = list.get(i);
            if (a > luckyNums.get(luckyNums.size() - 1)){
                // System.out.println(a);
                return a;
            }
        }
        return -1;
    }
    public static boolean canDivid(int a, int b) {
        return a % b == 0 || b % a == 0;
    }
}
