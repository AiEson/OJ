import java.util.ArrayList;
import java.util.List;

public class 跳跃游戏 {
    public static void main(String[] args) {
        System.out.println(new Solution().canJump(new int[]{3,2,1,0,4}));
    }
    static class Solution {
        public boolean canJump(int[] nums) {
//            if (nums.length == 1) return true;
//            if (nums[0] == 0) return false;
//            List<Integer> zeroPoi = new ArrayList<>();
//            int max = -Integer.MAX_VALUE;
//            for (int i = 0; i < nums.length; i++) {
//                if (nums[i] == 0) zeroPoi.add(i);
//                max = Math.max(max, nums[i]);
//            }
//            if (zeroPoi.size() == 0) return true;
//            if (max >= nums.length) return true;
//            l1: for (Integer integer : zeroPoi) {
//                for (int i = 0; i < integer; i++) {
//                    if (integer == nums.length - 1) {
//                        if (integer - i <= nums[i]) {
//                            //如果能跨过去
//                            return true;
//                        }
//                    }
//                    if (integer - i < nums[i]) {
//                        //如果能跨过去
////                        System.out.println(nums[i]);
//                        continue l1;
//                    }
//                }
//                return false;
//            }
//            return true;

            int range = 0;
            if (nums.length == 1) return true;
            for (int i = 0; i <= range; i++) {
                range = Math.max(nums[i] + i, range);
                if (range >= nums.length - 1 )return true;
            }
            return false;
        }
    }
}
