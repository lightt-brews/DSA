package Trees;

public class LC101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left,root.right);
    }

    public boolean isMirror(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }
        return isMirror(left.left,right.right) && isMirror(left.right,right.left);
    }

    public static void main(String[] args) {
        TreeNode root = TreeBuilder.fromArray("[1,2,2,3,4,4,3]");

        LC101_SymmetricTree obj = new LC101_SymmetricTree();
        boolean result = obj.isSymmetric(root);

        System.out.println("Is the tree symmetric? " + result);
    }
    
}
