public class ElementAppearingMoreThan25PercentInSortedArray {

    public static int findSpecialInteger(int[] arr) {

        int n = arr.length;
        int count = 1;

        for (int i = 1; i < n; i++) {

            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                count = 1;
            }

            if (count > n / 4) {
                return arr[i];
            }
        }

        return arr[0];
    }

    public static void main(String[] args) {

        int[] arr1 = {1, 2, 2, 6, 6, 6, 6, 7, 10};
        int[] arr2 = {1, 1};

        System.out.println(findSpecialInteger(arr1)); // 6
        System.out.println(findSpecialInteger(arr2)); // 1
    }
}