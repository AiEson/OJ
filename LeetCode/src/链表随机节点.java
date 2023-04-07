import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class 链表随机节点 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public static void main(String[] args) {


    }

    static class Solution{
        static List<Integer> nodes;
        static Random sjs = new Random();
        public Solution(ListNode head) {
            nodes = new ArrayList<>();
            while (head != null) {
                nodes.add(head.val);
                head = head.next;
            }
        }

        public int getRandom() {
            return nodes.get(sjs.nextInt(nodes.size()));
        }
    }
}
