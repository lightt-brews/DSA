package Trees;

import java.util.*;

public class LC0199_BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();

        if(root != null){
            queue.add(root);
        }

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0; i< size ; i++){

                TreeNode curr = queue.remove();

                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }

                if(i == size-1){
                    list.add(curr.val);
                }
            }
        }

        return list;
    }
    

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        LC0199_BinaryTreeRightSideView obj = new LC0199_BinaryTreeRightSideView();
        List<Integer> result = obj.rightSideView(root);

        System.out.println(result);
    }
}
