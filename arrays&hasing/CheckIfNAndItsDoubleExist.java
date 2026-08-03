import java.util.HashSet;

public class CheckIfNAndItsDoubleExist {

    public static boolean checkIfExist(int[] arr) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {

            if (set.contains(2 * num)) {
                return true;
            }

            if (num % 2 == 0 && set.contains(num / 2)) {
                return true;
            }

            set.add(num);
        }

        return false;
    }

    public static void main(String[] args) {

        int[] arr1 = {10, 2, 5, 3};
        int[] arr2 = {3, 1, 7, 11};
        int[] arr3 = {0, 0};

        System.out.println(checkIfExist(arr1)); // true
        System.out.println(checkIfExist(arr2)); // false
        System.out.println(checkIfExist(arr3)); // true
    }
}