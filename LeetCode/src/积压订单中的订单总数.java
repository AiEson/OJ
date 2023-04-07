import javax.swing.*;
import java.util.*;

public class 积压订单中的订单总数 {
    public static void main(String[] args) {
        System.out.println(new Solution().getNumberOfBacklogOrders(new int[][]{{7,1000000000,1}, {15,3,0}, {5,999999995,0}, {5,1,1}}));
    }
    static class Solution {
        public int getNumberOfBacklogOrders(int[][] orders) {
            PriorityQueue<Integer> buyQue = new PriorityQueue<>((i1, i2)->orders[i2][0] - orders[i1][0]);
            PriorityQueue<Integer> sellQue = new PriorityQueue<>(Comparator.comparingInt(i -> orders[i][0]));
            for(int i = 0; i < orders.length; i++){
                int[] o = orders[i];
                int type = o[2], price = o[0];
                if(type == 0){ // o是采购订单buy
                    while(!sellQue.isEmpty() && o[1] > 0){
                        int[] q = orders[sellQue.peek()];
                        if(q[0] > price)break;
                        int min = Math.min(o[1], q[1]);
                        o[1] -= min;
                        q[1] -= min;
                        if(q[1] == 0)sellQue.poll();
                    }
                    if(o[1] > 0)buyQue.offer(i);
                }else{ // o是销售订单 sell
                    while(!buyQue.isEmpty() && o[1] > 0){
                        int[] q = orders[buyQue.peek()];
                        if(q[0] < price)break;
                        int min = Math.min(o[1], q[1]);
                        o[1] -= min;
                        q[1] -= min;
                        if(q[1] == 0) buyQue.poll();;
                    }
                    if(o[1] > 0)sellQue.offer(i);
                }
            }

            int ret = 0;
            for(int[] o: orders)ret = (ret + o[1]) % (1000000007);
            return ret;
        }
    }
}
