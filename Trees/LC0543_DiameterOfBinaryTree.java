package Trees;

public class LC0543_DiameterOfBinaryTree {
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    public int height(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        diameter = Math.max(diameter, left + right);

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = TreeBuilder.fromArray("[1,2,3,4,5]");

        LC0543_DiameterOfBinaryTree obj = new LC0543_DiameterOfBinaryTree();
        int result = obj.diameterOfBinaryTree(root);

        System.out.println("Diameter of the binary tree: " + result);
    }
    
}
