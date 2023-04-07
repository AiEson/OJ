import java.util.*;

public class 股票价格波动 {
    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        stockPrice.update(1, 10); // 时间戳为 [1] ，对应的股票价格为 [10] 。
        stockPrice.update(2, 5);  // 时间戳为 [1,2] ，对应的股票价格为 [10,5] 。
        stockPrice.current();     // 返回 5 ，最新时间戳为 2 ，对应价格为 5 。
        stockPrice.maximum();     // 返回 10 ，最高价格的时间戳为 1 ，价格为 10 。
        stockPrice.update(1, 3);  // 之前时间戳为 1 的价格错误，价格更新为 3 。
        // 时间戳为 [1,2] ，对应股票价格为 [3,5] 。
        stockPrice.maximum();     // 返回 5 ，更正后最高价格为 5 。
        stockPrice.update(4, 2);  // 时间戳为 [1,2,4] ，对应价格为 [3,5,2] 。
        stockPrice.minimum();     // 返回 2 ，最低价格时间戳为 4 ，价格为 2 。
    }
    static class StockPrice {
        PriorityQueue<int[]> min = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        PriorityQueue<int[]> max = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int lastTime = -1, lastPrice = -1;
        Map<Integer, Integer> times = new HashMap<>();

        public void update(int timestamp, int price) {
            if(lastTime <= timestamp) {
                this.lastTime = timestamp;
                this.lastPrice = price;
            }
            min.offer(new int[]{timestamp, price});
            max.offer(new int[]{timestamp, price});
            times.put(timestamp, price);
        }

        public int current() {
            return lastPrice;
        }

        public int minimum() {
            for (;;) {
                int[] minPrice = min.peek();
                if (minPrice[1] == times.get(minPrice[0])) {
                    return minPrice[1];
                }
                min.poll();
            }
        }

        public int maximum() {
            for (;;) {
                int[] maxPrice = max.peek();
                if (maxPrice[1] == times.get(maxPrice[0])) {
                    return maxPrice[1];
                }
                max.poll();
            }
        }
    }

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
}
