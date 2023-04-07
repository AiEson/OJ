public class 合并两个链表 {
    public static void main(String[] args) {
        System.out.println("aaa");
    }

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    static class Solution {
        public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
            // 0
            ListNode node = list1;
            for (int i = 0; i < a - 1; i++) {
                node = node.next;
            }
            ListNode nodeb = node;
            for (int i = 0; i <= (b - a) + 1; i++) {
                nodeb = nodeb.next;
            }
            node.next = list2;
            ListNode list2_iter = list2;
            while (list2_iter.next != null) {
                list2_iter = list2_iter.next;
            }
            list2_iter.next = nodeb;
            return list1;
        }
    }
}
