public class 二叉树着色游戏 {
    public static void main(String[] args) {

    }

//     Definition for a binary tree node.
      public class TreeNode {
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

    class Solution {
        private int x, lsz, rsz;
        public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
            this.x = x;
            dfs(root);
            return Math.max(Math.max(lsz, rsz), n - 1 - lsz - rsz) * 2 > n;

        }
        private int dfs(TreeNode node) {
            if (node == null)
                return 0;
            int ls = dfs(node.left);
            int rs = dfs(node.right);
            if (node.val == x) {
                lsz = ls;
                rsz = rs;
            }
            return ls + rs + 1;
        }

    }
}
