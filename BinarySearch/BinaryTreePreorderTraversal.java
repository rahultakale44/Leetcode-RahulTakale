import java.util.*;

public class BinaryTreePreorderTraversal {

    // Definition of a Binary Tree Node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Preorder Traversal: Root -> Left -> Right
    public static List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        preorder(root, result);

        return result;
    }

    private static void preorder(TreeNode node, List<Integer> result) {

        if (node == null) {
            return;
        }

        // Visit Root
        result.add(node.val);

        // Traverse Left
        preorder(node.left, result);

        // Traverse Right
        preorder(node.right, result);
    }

    public static void main(String[] args) {

 

        TreeNode root = new TreeNode(1);

        root.right = new TreeNode(2);

        root.right.left = new TreeNode(3);

        List<Integer> result = preorderTraversal(root);

        System.out.println("Preorder Traversal: " + result);
    }
}