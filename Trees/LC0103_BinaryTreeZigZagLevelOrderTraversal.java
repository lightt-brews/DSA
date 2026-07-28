package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class LC0103_BinaryTreeZigZagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> levelorder = new ArrayList<>();
        boolean lefttoright = true;

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
            
            if(lefttoright){
                levelorder.add(list);
                lefttoright = false;
            }
            else{
                Collections.reverse(list); 
                levelorder.add(list);
                lefttoright = true;
            }
            
        }

        return levelorder;
    }


    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        LC0103_BinaryTreeZigZagLevelOrderTraversal obj = new LC0103_BinaryTreeZigZagLevelOrderTraversal();
        List<List<Integer>> result = obj.zigzagLevelOrder(root);

        for(List<Integer> level : result){
            System.out.println(level);
        }
    }
    
}
