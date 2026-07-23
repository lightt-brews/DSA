package Trees;

public class LC0104_MaxDepthofBinaryTree {
    
    public static int maxDepth(TreeNode root) {

        if (root == null)
            return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {

        TreeNode root = TreeBuilder.fromArray("[3,9,20,null,null,15,7]");

        int depth = maxDepth(root);

        System.out.println("Max Depth = " + depth);
    }
}
