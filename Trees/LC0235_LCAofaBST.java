package Trees;

public class LC0235_LCAofaBST {
    

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        if (root == p || root == q){
            return root;
        }

        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p , q);
        }
        if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }


    public static void main(String[] args){
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(8);
        LC0235_LCAofaBST solution = new LC0235_LCAofaBST();
        TreeNode result = solution.lowestCommonAncestor(root, p, q);
        System.out.println(result.val);
    }
}
