public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[start] <= nums[mid]) {

                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            } else {

                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 3;

        int[] nums3 = {1};
        int target3 = 0;

        System.out.println(search(nums1, target1)); // 4
        System.out.println(search(nums2, target2)); // -1
        System.out.println(search(nums3, target3)); // -1
    }
}