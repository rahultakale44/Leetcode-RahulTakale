import java.util.Arrays;

public class ReplaceElementsWithGreatestElementOnRightSide {

    public static int[] replaceElements(int[] arr) {

        int maxRight = -1;

        for (int i = arr.length - 1; i >= 0; i--) {

            int current = arr[i];

            arr[i] = maxRight;

            maxRight = Math.max(maxRight, current);
        }

        return arr;
    }

    public static void main(String[] args) {

        int[] arr1 = {17, 18, 5, 4, 6, 1};
        int[] arr2 = {400};

        System.out.println(Arrays.toString(replaceElements(arr1))); // [18, 6, 6, 6, 1, -1]
        System.out.println(Arrays.toString(replaceElements(arr2))); // [-1]
    }
}
