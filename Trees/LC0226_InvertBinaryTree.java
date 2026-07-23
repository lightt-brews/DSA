package Trees;

public class LC0226_InvertBinaryTree {

    public static TreeNode invertTree(TreeNode root) {

        if (root == null)
            return null;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    public static void main(String[] args) {

        TreeNode root = TreeBuilder.fromArray("[3,9,20,null,null,15,7]");

        TreePrinter.levelOrder(root);

        TreeNode invertedRoot = invertTree(root);

        TreePrinter.levelOrder(invertedRoot);
    }
}
