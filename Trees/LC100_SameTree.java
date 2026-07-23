package Trees;

public class LC100_SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if (p == null || q == null){
            return false;
        }
        if (p.val != q.val){
            return false;
        }
        
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    public static void main(String[] args) {
        TreeNode p = TreeBuilder.fromArray("[1,2,3]");
        TreeNode q = TreeBuilder.fromArray("[1,2,3]");

        LC100_SameTree obj = new LC100_SameTree();
        boolean result = obj.isSameTree(p, q);

        System.out.println("Are the trees the same? " + result);
    }
}
