package GuoSai2021;

import java.time.LocalDateTime;
import java.util.Date;

public class C完全日期 {

    public static boolean isTotalNum(int n) {
        int nn = (int) Math.sqrt(n);
        return n - nn * nn == 0;
    }

    public static int sum(String ds) {
        int sum = 0;
        for (char c : ds.toCharArray())
            sum += Character.isDigit(c) ? Integer.parseInt(String.valueOf(c)) : 0;
        return sum;
    }

    public static boolean check(String ds) {
        return isTotalNum(sum(ds));
    }
    public static void main(String[] args) {
        int cnt = 0;
        LocalDateTime ldt = LocalDateTime.of(2001,1,1,1,1);
        while(true) {
            ldt = ldt.plusDays(1);
            String dateStr = String.valueOf(ldt.toLocalDate());
            cnt += check(dateStr) ? 1 : 0;
            if (dateStr.equals("2021-12-31")) break;
        }
        System.out.println(cnt);
    }
}
