
import java.util.*;

public class BalancedBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private static int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = height(node.right);
        if (rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }

    // Build a binary tree from level-order input
    public static TreeNode buildTree(String[] values) {
        if (values.length == 0 || values[0].equalsIgnoreCase("null")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;

        while (!queue.isEmpty() && i < values.length) {
            TreeNode current = queue.poll();

            if (i < values.length &&
                !values[i].equalsIgnoreCase("null")) {
                current.left = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(current.left);
            }
            i++;

            if (i < values.length &&
                !values[i].equalsIgnoreCase("null")) {
                current.right = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter level-order tree values (use null for missing nodes):");
        String[] values = sc.nextLine().trim().split("\\s+");

        TreeNode root = buildTree(values);

        System.out.println("Is the tree balanced? " + isBalanced(root));

        sc.close();
    }
}
