import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.List;

public class 统计按位或能得到最大值的子集数目 {
    public static void main(String[] args) {
        System.out.println(new Solution().countMaxOrSubsets(new int[]{3, 2, 1, 5}));
    }
    static class Solution {
        int[] nums;
        int max = 0;
        public int countMaxOrSubsets(int[] nums) {
            this.nums = nums;
            for (int num : nums)
                max |= num;
            return dfs(0, 0);
        }
        private int dfs(int nowVal, int nowDep) {
            if (nowDep == nums.length) return nowVal == max ? 1 : 0;
            return dfs(nowVal | nums[nowDep], nowDep + 1) + dfs(nowVal, nowDep + 1);
        }
    }
}
