import java.util.Arrays;

public class 特殊数组的特征值 {
    public static void main(String[] args) {
        System.out.println(new Solution().specialArray(new int[]{0, 4, 3, 0, 4}));
    }
    static class Solution {
        public int specialArray(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            for(int i = 0; i < n; i++) {
                if(nums[i] >= n - i) {
                    if(i == 0 || nums[i - 1] < n - i)//如果i == 0则直接输出 n - i，否则需验证前一个数是否小于n - i
                        return n - i;
                }
            }
            return -1;
        }
    }
}
