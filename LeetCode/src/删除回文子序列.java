public class 删除回文子序列 {
    public static void main(String[] args) {
        System.out.println(new Solution().removePalindromeSub("aba"));
    }
    static class Solution {
            public int removePalindromeSub(String s) {
                return s.equals(new StringBuffer(s).reverse().toString())? 1 : 2 ;
            }
//        public int removePalindromeSub(String s) {
//            char[] a = s.toCharArray();
//            int n = a.length;
//            for (int i = 0; i < n; i++) {
//                if (a[i] != a[n - 1 - i]) return 2;
//            }
//            return 1;
//        }
    }
}
