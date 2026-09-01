import java.util.Scanner;

public class DetectCapital {

    public static boolean detectCapitalUse(String word) {

        int capitalCount = 0;

        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                capitalCount++;
            }
        }

        if (capitalCount == 0) {
            return true;
        }

        if (capitalCount == word.length()) {
            return true;
        }

        return capitalCount == 1 &&
               Character.isUpperCase(word.charAt(0));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter word: ");
        String word = sc.nextLine();

        boolean result = detectCapitalUse(word);

        System.out.println("Output: " + result);

        sc.close();
    }
}