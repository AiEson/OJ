import java.util.Arrays;

public class 消失的两个数字 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().missingTwo(new int[]{1})));
    }

    static class Solution {
        public int[] missingTwo(int[] nums) {
            Arrays.sort(nums);
            int[] ret = new int[2];
            int flag = 0;
            if (nums.length == 1) {
                if (nums[0] == 3) {
                    ret[0] = 1;
                    ret[1] = 2;
                }
            }
            if (nums[nums.length - 1] == nums.length) {
                ret[0] = nums.length + 1;
                ret[1] = nums.length + 2;
            } else if (nums[nums.length - 1] == nums.length + 1) {
                ret[0] = nums.length + 2;
                for (int i = 1; i <= nums.length; i++) {
                    if (nums[i - 1] != i) {
                        ret[1] = i;
                        break;
                    }
                }
            } else {
                for (int i = 1; i <= nums.length; i++) {
                    if (nums[i - 1] != i + flag) {
                        ret[flag++] = i + flag - 1;
//                        break;
                    }
                    if (flag == 2) break;
                }
            }
            return ret;
        }
    }
}
