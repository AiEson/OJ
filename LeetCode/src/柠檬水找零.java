import java.util.HashMap;
import java.util.Map;

public class 柠檬水找零 {
    public static void main(String[] args) {
        System.out.println(new Solution().lemonadeChange(new int[]{5,5,10,10,20}));
    }
    static class Solution {
        public boolean lemonadeChange(int[] bills) {
            int five = 0, ten = 0;
            for (int bill : bills) {
//                System.out.println("Now: " + bill + " ----" + "5: " + map.get(5) + " |--| 10: " + map.get(10));
                if (bill == 5) ++five;
                else if (bill == 10) {
                    ++ten;
                    --five;
                    if (five < 0) return false;
                }
                else if (bill == 20) {
                    //两种找零情况，此处使用贪心，优先找零10，10找不动再3*5
                    if (ten > 0) {
                        if (five - 1 < 0) return false;
                        --ten;
                        --five;
                    } else if (five > 2) {
                        five -= 3;
                    } else return false;
                }
            }
            return true;
        }
    }
}
