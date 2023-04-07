public class 修剪二叉搜索树 {
    public static void main(String[] args) {

    }
    static class Solution {
        public TreeNode trimBST(TreeNode root, int low, int high) {
            if (root == null) return null;

            int val = root.val;
            if (val > high) return trimBST(root.left, low, high);
            if (val < low) return trimBST(root.right, low, high);

            root.right = trimBST(root.right, low, high);
            root.left = trimBST(root.left, low, high);

            return root;
        }
    }
}


