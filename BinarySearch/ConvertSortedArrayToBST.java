
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class ConvertSortedArrayToBST {

    public static TreeNode sortedArrayToBST(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    public static TreeNode construct(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = construct(nums, left, mid - 1);
        root.right = construct(nums, mid + 1, right);

        return root;
    }

    public static void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};

        TreeNode root = sortedArrayToBST(nums);

        System.out.print("Inorder Traversal: ");
        inorder(root);
    }
}
