package Trees;

import java.util.*;

public class TreeBuilder {

    public static TreeNode fromArray(String input) {

        input = input.trim();

        if (input.equals("[]"))
            return null;

        input = input.substring(1, input.length() - 1);

        String[] arr = input.split(",");

        if (arr.length == 0 || arr[0].trim().equals("null"))
            return null;

        TreeNode root = new TreeNode(Integer.parseInt(arr[0].trim()));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {

            TreeNode curr = queue.poll();

            if (i < arr.length && !arr[i].trim().equals("null")) {
                curr.left = new TreeNode(Integer.parseInt(arr[i].trim()));
                queue.offer(curr.left);
            }
            i++;

            if (i < arr.length && !arr[i].trim().equals("null")) {
                curr.right = new TreeNode(Integer.parseInt(arr[i].trim()));
                queue.offer(curr.right);
            }
            i++;
        }

        return root;
    }
}