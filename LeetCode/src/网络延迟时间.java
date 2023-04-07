import java.util.*;

public class 网络延迟时间 {
    public static void main(String[] args) {
        System.out.println(new Solution().networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
    }
    static class Solution {
        public int networkDelayTime(int[][] times, int n, int k) {
            // 节点编号是从 1 开始的，所以要一个大小为 n + 1 的邻接表
            List<int[]>[] graph = new LinkedList[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new LinkedList<>();
            }
            // 构造图
            for (int[] edge : times) {
                int from = edge[0];
                int to = edge[1];
                int weight = edge[2];
                // from -> List<(to, weight)>
                // 邻接表存储图结构，同时存储权重信息
                graph[from].add(new int[]{to, weight});
            }
            // 启动 dijkstra 算法计算以节点 k 为起点到其他节点的最短路径
            int[] distTo = dijkstra(k, graph);

            // 找到最长的那一条最短路径
            int res = 0;
            for (int i = 1; i < distTo.length; i++) {
                if (distTo[i] == Integer.MAX_VALUE) {
                    // 有节点不可达，返回 -1
                    return -1;
                }
                res = Math.max(res, distTo[i]);
            }
            return res;
        }
        class State{
            int id;
            int distFromStart;

            State(int id, int distFromStart) {
                this.id = id;
                this.distFromStart = distFromStart;
            }
        }
        int[] dijkstra(int start, List<int[]>[] graph) {
            int[] distTo = new int[graph.length];
            Arrays.fill(distTo, Integer.MAX_VALUE);
            PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingInt(value -> value.distFromStart));

            distTo[start] = 0;

            pq.add(new State(start, 0));

            while (!pq.isEmpty()) {
                State nowState = pq.poll();
                int nowID = nowState.id;
                int nowDist = nowState.distFromStart;

                if (nowDist > distTo[nowID]) continue;

                for (int[] neighbor : graph[nowID]) {
                    int nextID = neighbor[0];
                    int nextDistance = neighbor[1] + distTo[nowID];
                    if (distTo[nextID] > nextDistance) {
                        distTo[nextID] = nextDistance;
                        pq.add(new State(nextID, nextDistance));
                    }
                }
            }
            return distTo;

        }
















//        int[] dijkstra(int start, List<int[]>[] graph) {
//            int[] distTo = new int[graph.length];
//            Arrays.fill(distTo, Integer.MAX_VALUE);
//            distTo[start] = 0;
//            Queue<State> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.distFromStart));
//            pq.offer(new State(start, 0));
//
//            while (!pq.isEmpty()) {
//                State curState = pq.poll();
//                int curNodeID = curState.id;
//                int curDistFromStart = curState.distFromStart;
//
//                if (curDistFromStart > distTo[curNodeID]) {
//                    continue;
//                }
//
//                for (int[] neighbor : graph[curNodeID]) {
//                    int nextNodeID = neighbor[0];
//                    int distToNextNode = distTo[curNodeID] + neighbor[1];
//                    if (distTo[nextNodeID] > distToNextNode) {
//                        distTo[nextNodeID] = distToNextNode;
//                        pq.offer(new State(nextNodeID, distToNextNode));
//                    }
//                }
//            }
//            return distTo;
//        }

    }
}
