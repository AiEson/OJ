import java.util.Deque;

public class 文件夹操作日志搜集器 {
    public static void main(String[] args) {
        System.out.println(new Solution().minOperations(new String[]{"d1/", "d2/", "../", "d21/", "./"}));
    }
}
class Solution {
    public int minOperations(String[] logs) {
        int ret = 0;
        for (String log : logs) {
            if (log.charAt(0) == '.') {
                if (log.length() == 3)
                    ret = Math.max(ret - 1, 0);
            } else ++ret;
        }
        return ret;
    }
}