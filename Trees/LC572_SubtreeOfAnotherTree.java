package Trees;

public class LC572_SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null){
            if(subRoot == null){
                return true;
            }
            else{
                return false;
            }
        }
        
        return (isSameTree(root,subRoot) || isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot));
    }
    public boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null){
            return true;
        }
        if (root == null || subRoot == null){
            return false;
        }
        if (root.val != subRoot.val){
            return false;
        }
        
        return isSameTree(root.left,subRoot.left) && isSameTree(root.right,subRoot.right);
    }

    public static void main(String[] args) {
        TreeNode root = TreeBuilder.fromArray("[3,4,5,1,2]");
        TreeNode subRoot = TreeBuilder.fromArray("[4,1,2]");

        LC572_SubtreeOfAnotherTree obj = new LC572_SubtreeOfAnotherTree();
        boolean result = obj.isSubtree(root, subRoot);

        System.out.println("Is subRoot a subtree of root? " + result);
    }
    
}
