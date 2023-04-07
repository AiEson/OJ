import java.util.*;

public class 两数之和 {
    public static void main(String[] args) {
        int[] aaa = {3, 2, 4, 1, 1, 1, 1};
        System.out.println(Arrays.toString(new Solution().twoSum(aaa, 6)));
    }
    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] ret = new int[2];
            List<Cls> clsList = new ArrayList<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                clsList.add(new Cls(i, nums[i]));
            }
            clsList.sort(Comparator.comparingInt(o -> o.num));
            for (int i = 0; i < clsList.size(); i++) {
                Cls cls = clsList.get(i);
                Cls aaa = binarySearch(clsList, target - cls.num);
                if (aaa != null) {
                    if (cls.idx == aaa.idx){
                        ret[0] = cls.idx;
                        //重复，且变量num相等
                        clsList.remove(i);
                        for (Cls cls1 : clsList) {
                            if (cls1.num == cls.num) {
                                ret[1] = cls1.idx;
                                break;
                            }
                        }
                    } else {
                        ret[0] = cls.idx;
                        ret[1] = aaa.idx;
                    }
                    break;
                }
            }
            Arrays.sort(ret);
            return ret;
        }
        public static Cls binarySearch(List<Cls> nums,int key){
            int start=0;
            int end=nums.size()-1;
            int mid=-1;
            while(start<=end){
                mid=(start+end)/2;
                if(nums.get(mid).num ==key){
                    return nums.get(mid);
                }else if(nums.get(mid).num<key){
                    start=mid+1;
                }else if(nums.get(mid).num>key){
                    end=mid-1;
                }
            }
            return null;
        }
        static class Cls{
            public int idx, num;
            public Cls(int idx,int num){
                this.idx = idx;
                this.num = num;
            }
        }
    }

}
