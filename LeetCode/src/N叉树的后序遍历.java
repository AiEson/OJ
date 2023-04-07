import java.util.ArrayList;
import java.util.List;

public class N叉树的后序遍历 {
    public static void main(String[] args) {

    }
    static class Solution {
        List<Integer> rst = new ArrayList<>();
        private void iter(Node node) {
            if (node == null) return;
            for (int i = 0; i < node.children.size(); i++) {
                iter(node.children.get(i));
            }
            rst.add(node.val);
        }
        public List<Integer> postorder(Node root) {
            iter(root);
            return rst;
        }
    }
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
