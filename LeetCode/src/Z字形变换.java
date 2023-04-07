import java.util.ArrayList;
import java.util.List;

public class Z字形变换 {
    public static void main(String[] args) {
        System.out.println(new Solution().convert("PAYPALISHIRING", 4));
    }
    static class Solution {
        public String convert(String s, int numRows) {
            if (s.length() == 1) return String.valueOf(s.charAt(0));
            if (numRows == 1) return s;
            StringBuilder ret = new StringBuilder();
            List<StringBuilder> list = new ArrayList<>();
            for (int i = 0; i < numRows; i++)
                list.add(new StringBuilder());
            int nRow = 0;
            final int[] stat = new int[]{1, -1};
            int nStat = 1;
            for (int i = 0; i < s.toCharArray().length; i++) {
                list.get(nRow).append(s.charAt(i));
                nRow += nStat;
                if (nRow % (numRows - 1) == 0) nStat = -nStat;
            }
            for (StringBuilder stringBuilder : list)
                ret.append(stringBuilder);
            return ret.toString();
        }
    }
}
