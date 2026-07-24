package Trees;

public class LC0098_ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode root, long min, long max){
        if(root == null){
            return true;
        }
        if(root.val <= min || root.val >= max){
            return false;
        }
        return helper (root.left, min, root.val) && helper(root.right, root.val, max);
        
    }

    public static void main(String[] args) {
        TreeNode root = TreeBuilder.fromArray("[2,1,3]");

        LC0098_ValidateBST obj = new LC0098_ValidateBST();
        boolean result = obj.isValidBST(root);

        System.out.println("Is the tree a valid BST? " + result);
    }
}
