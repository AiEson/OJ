public class 加油站 {
    public static void main(String[] args) {
        System.out.println(new Solution().canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
    }
    static class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
//            l1: for (int i = 0; i < gas.length; i++) {
//                if (gas[i]==0) continue ;
//                int oil = 0;
//                l2: for (int j = i; j < gas.length + i; j++) {
//                    //从 i 出发，向后迭代
//                    oil += gas[j % gas.length];
//                    oil -= cost[j % gas.length];
//                    if (oil < 0) {
//                        //如果到不了，此路不通，继续l1
//                        continue l1;
//                    }
//                }
//                return i;
//            }
//            return -1;

            //方法2
//            int min = Integer.MAX_VALUE;
//            int fullOil = 0;
//            for (int i = 0; i < gas.length; i++) {
//                int n = gas[i] - cost[i];
//                fullOil += n;
//                min = Math.min(min, fullOil);
//            }
//            if (fullOil < 0) return -1;
//            if (min >= 0) return 0;
//
//            for (int i = gas.length - 1; i >= 0; i--) {
//                min += gas[i] - cost[i];
//                if (min >= 0) return i;
//            }
//            return -1;
            int[] rest = new int[gas.length];
            for (int i = 0; i < gas.length; i++) {
                rest[i] = gas[i] - cost[i];
            }
            int sum = 0;
            int nSum = 0;
            int start = 0;
            for (int i = 0; i < rest.length; i++) {
                sum += rest[i];
                nSum += rest[i];
                if (nSum < 0) {
                    nSum = 0;
                    start = i + 1;
                }
            }
            if (sum < 0) return -1;
            return start <= gas.length - 1 ? start : -1;
        }
    }
}
