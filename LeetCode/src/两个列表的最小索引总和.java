import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 两个列表的最小索引总和 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"KFC", "Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"})));
    }
    static  class Solution {
        public String[] findRestaurant(String[] list1, String[] list2) {
            return Arrays.stream(list1).filter(a -> Arrays.asList(list2).contains(a)).collect(Collectors.toList()).toArray(new String[0]);
        }
    }
}
