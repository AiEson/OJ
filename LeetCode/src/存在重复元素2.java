import java.util.Arrays;
import java.util.Comparator;

public class 存在重复元素2 {
    public static void main(String[] args) {
        int[] test = {1,2,3,1,2,3};
        System.out.println(new Solution().containsNearbyDuplicate(test, 2));
    }
    static class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Cls[] clss = new Cls[nums.length];
            for (int i = 0; i < nums.length; i++) {
//                System.out.println(nums[i]);
                clss[i] = new Cls().setIdx(i).setNum(nums[i]);
            }

            Arrays.sort(clss, new Comparator<Cls>() {
                @Override
                public int compare(Cls o1, Cls o2) {
                    if (o1.num == o2.num) {
                        return o1.idx - o2.idx;
                    } else {
                        return o1.num - o2.num;
                    }
                }
            });
            //滑窗
            for (int i = 0; i < clss.length - 1; i++) {
                Cls c1 = clss[i], c2 = clss[i + 1];
                if (c2.idx - c1.idx <= k && c1.num == c2.num) return true;
            }

            return false;
        }
        class Cls {
            public int num, idx;

            public Cls setNum(int num) {
                this.num = num;
                return this;
            }

            public Cls setIdx(int idx) {
                this.idx = idx;
                return this;
            }
        }
    }
}
