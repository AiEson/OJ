public class 复数乘法 {
    public static void main(String[] args) {
        System.out.println(new Solution().complexNumberMultiply("1+-1i", "1+-1i"));
    }
    static class Solution {
        public String complexNumberMultiply(String num1, String num2) {
            // (a + bi) * (c + di)
            // ac + bci + adi - bd
            String[] num1arr = num1.split("\\+");
            String[] num2arr = num2.split("\\+");
            int a = Integer.parseInt(num1arr[0]);
            int b = Integer.parseInt(num1arr[1].substring(0, num1arr[1].length() - 1));
            int c = Integer.parseInt(num2arr[0]);
            int d = Integer.parseInt(num2arr[1].substring(0, num2arr[1].length() - 1));
            return (a*c - b*d) + "+" + (a*d + b*c) + "i";
        }
    }
}
