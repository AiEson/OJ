import java.util.*;

public class 剑指OfferII060出现频率最高的k个数字 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }
    static class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, C> map = new HashMap<>();
            for (int num : nums) {
                if (map.containsKey(num)) {
                    map.get(num).add1();
                }
                else {
                    map.put(num, new C(num));
                }
            }
//            System.out.println(map.keySet());
            List<C> list = new ArrayList<>();
            for (Integer integer : map.keySet()) {
                list.add(map.get(integer));
            }
            Collections.sort(list);
//            System.out.println(list);
            int[] ret = new int[k];
            for (int i = 0; i < k; i++) {
                ret[i] = list.get(i).data;
            }
            return ret;
        }

        static class C implements Comparable<C> {
            public int data, num = 0;
            public C(int data) {
                this.data = data;
            }
            public void add1() {
                ++this.num;
            }

            @Override
            public String toString() {
                return "C{" +
                        "data=" + data +
                        ", num=" + num +
                        '}';
            }

            @Override
            public int compareTo(C o) {
                return o.num - this.num ;
            }
        }
    }
}
