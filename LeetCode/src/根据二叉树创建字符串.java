public class 根据二叉树创建字符串 {
    public static void main(String[] args) {
        System.out.println(new Solution().tree2str(new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3))));
    }


    static class Solution {
        public String tree2str(TreeNode root) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            if (left == null && right == null) return root.val + "";
            else if (left == null)
                return root.val + "()(" + tree2str(right) + ")";
             else if (right == null)
                return root.val + "(" + tree2str(left) + ")";
             else
                return root.val + "(" + tree2str(left) +  ")(" + tree2str(right) + ")";

        }
    }

      static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
     }

}
