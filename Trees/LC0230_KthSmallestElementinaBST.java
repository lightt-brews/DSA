package Trees;

public class LC0230_KthSmallestElementinaBST {

    int i =0;
    int ans = 0;
    public int kthSmallest(TreeNode root, int k) {

        if (root == null || i >= k){
            return ans;
        }
        kthSmallest(root.left , k);

        i++;
        if(i == k){
            ans  = root.val;
            return ans;
        }
        
        if (i < k) {
            kthSmallest(root.right, k);
        }
        return ans;
    }
    
    public static void main(String[] args) {
        TreeNode root = TreeBuilder.fromArray("[3,1,4,null,2]");
        int k = 1;

        LC0230_KthSmallestElementinaBST obj = new LC0230_KthSmallestElementinaBST();
        int result = obj.kthSmallest(root, k);
        System.out.println("The " + k + "th smallest element in the BST is: " + result);
    }
}
