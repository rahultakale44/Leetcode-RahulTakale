public class ValidMountainArray {

    public static boolean validMountainArray(int[] arr) {

        int n = arr.length;

        if (n < 3) {
            return false;
        }

        int i = 0;

        while (i + 1 < n && arr[i] < arr[i + 1]) {
            i++;
        }

        if (i == 0 || i == n - 1) {
            return false;
        }

        while (i + 1 < n && arr[i] > arr[i + 1]) {
            i++;
        }

        return i == n - 1;
    }

    public static void main(String[] args) {

        int[] arr1 = {0, 2, 3, 4, 5, 2, 1, 0};
        int[] arr2 = {3, 5, 5};
        int[] arr3 = {0, 1, 2, 3};

        System.out.println(validMountainArray(arr1)); 
        System.out.println(validMountainArray(arr2)); 
        System.out.println(validMountainArray(arr3)); 
    }
}