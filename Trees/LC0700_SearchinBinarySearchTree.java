package Trees;

public class LC0700_SearchinBinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        if (root.val == val){
            return root;
        }
        if(root.val < val){
            return searchBST(root.right,val);
        }

        return searchBST(root.left,val);
    }

    public static void main(String[] args) {
        TreeNode root = TreeBuilder.fromArray("[4,2,7,1,3]");
        int val = 2;

        LC0700_SearchinBinarySearchTree obj = new LC0700_SearchinBinarySearchTree();
        TreeNode result = obj.searchBST(root, val);

        System.out.println("Resulting subtree:");
        TreePrinter.levelOrder(result);
    }
    
}
