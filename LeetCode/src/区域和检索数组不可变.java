public class 区域和检索数组不可变 {
    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0, 2));
    }
    static class NumArray {
        int[] sumArr = {};
        public NumArray(int[] nums) {
            sumArr = new int[nums.length];
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                sumArr[i] = sum;
            }
        }

        public int sumRange(int left, int right) {
            return sumArr[right] - (left == 0 ? 0 : sumArr[left - 1]);
        }
    }
}

