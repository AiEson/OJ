public class 检查句子中的数字是否递增 {
    public static void main(String[] args) {
        System.out.println(new Solution().areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles"));
    }
    static class Solution {
        public boolean areNumbersAscending(String s) {
            int n = s.length(), preNum = -1, curNum = 0; // preNum是上一个被解析出来的数字型 token，curNum是正在被解析中的数字型 token。将 preNum 设置成-1，可以避免在循环中做额外的判断。
            char pre = ' '; // 前一个字符
            for(int i = 0; i < n; i++){
                char c = s.charAt(i);
                if(c == ' '){ // 空格标志着上一个token 的结束，下个 token 的开始
                    if(pre <= '9'){ // 前一个字符，不是数字就是字母，因为'9' < 'a'，所以可简化判断条件，不必调用Character.isDigit
                        if(curNum <= preNum)return false;
                        preNum = curNum;
                        curNum = 0;
                    }
                }else if(c <= '9'){
                    curNum = curNum * 10 + (int)(c - '0');
                }
                pre = c;
            }
            return s.charAt(n - 1) > '9' || curNum > preNum; // s 没有尾随 空格，要注意判断最后一个字符是数字的情况
        }
    }
}
