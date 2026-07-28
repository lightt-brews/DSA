package Trees;

import java.util.*;

public class LC0102_BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> levelorder = new ArrayList<>();

        if(root != null){
            queue.add(root);
        }

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            for(int i=0; i< size ; i++){

                TreeNode curr = queue.remove();
                list.add(curr.val);

                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }

            levelorder.add(list);
        }

        return levelorder;
    }
    

    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        LC0102_BinaryTreeLevelOrderTraversal obj = new LC0102_BinaryTreeLevelOrderTraversal();
        List<List<Integer>> result = obj.levelOrder(root);

        for(List<Integer> level : result){
            System.out.println(level);
        }
    }
}
