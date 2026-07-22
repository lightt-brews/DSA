package Trees;

import java.util.*;

public class TreePrinter {

    public static void levelOrder(TreeNode root) {

        if (root == null) {
            System.out.println("Empty Tree");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {

                TreeNode curr = queue.poll();

                if (curr == null) {
                    System.out.print("null ");
                    continue;
                }

                System.out.print(curr.val + " ");

                if (curr.left != null)
                    queue.offer(curr.left);

                if (curr.right != null)
                    queue.offer(curr.right);
            }

            System.out.println();
        }
    }
}