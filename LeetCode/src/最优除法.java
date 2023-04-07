import java.util.Arrays;

public class 最优除法 {
    public static void main(String[] args) {
        System.out.println(new Solution().optimalDivision(new int[]{1000, 100, 10, 2}));
    }
    static class Solution {
        public String optimalDivision(int[] nums) {
            int n = nums.length;
            if (n == 1) return nums[0] + "";
            if (n == 2) return nums[0] + "/" + nums[1];
            StringBuilder rst = new StringBuilder();
            rst.append(nums[0]).append("/(").append(nums[1]);
            for (int i = 2; i < nums.length; i++)
                rst.append("/").append(nums[i]);
            return rst.append(")").toString();
        }


//        public String optimalDivision(int[] nums) {
//            int n = nums.length;
//            if (n == 1) return nums[0] + "";
//            if (n == 2) return nums[0] + "/" + nums[1];
//            StringBuffer rst = new StringBuffer(nums[0] + "/(" + nums[1]);
//            for (int i = 2; i < nums.length; i++)
//                rst.append("/").append(nums[i]);
//            return rst.append(")").toString();
//        }
//        public String optimalDivision(int[] nums) {
//            return nums.length == 1 ? nums[0] + "" : (nums.length == 2 ? nums[0] + "/" + nums[1] : nums[0] + "/(" +  Arrays.toString(Arrays.copyOfRange(nums, 1, nums.length)).replaceAll(", ", "/").substring(1).replace("]", "") + ")");
//        }
    }
}
