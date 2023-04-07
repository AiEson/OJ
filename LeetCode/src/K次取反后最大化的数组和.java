import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class K次取反后最大化的数组和 {
    public static void main(String[] args) {
        System.out.println(new Solution().largestSumAfterKNegations(new int[]{-2, 9, 9, 8, 4}, 5));
    }
    static class Solution {
        public int largestSumAfterKNegations(int[] nums, int k) {
            IntStream stream = Arrays.stream(nums);
            Stream<Integer> integerStream = stream.boxed();
            Integer[] integers = integerStream.toArray(Integer[]::new);
            Arrays.sort(integers, Comparator.comparingInt(Math::abs));
            nums = Arrays.stream(integers).mapToInt(Integer::valueOf).toArray();
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] <= 0) {
                    --k;
                    nums[i] *= -1;
                    if (k == 0) break;
                }
            }
            if (k > 0) nums[0] *= k % 2 == 0 ? 1 : -1;
            int ret = 0;
            for (int num : nums)
                ret += num;
            return ret;

//            PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(a -> nums[a]));

        }
    }
}
