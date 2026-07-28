public class SmallestPalindromicRearrangementI {

    public static String smallestPalindrome(String s) {

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder left = new StringBuilder();
        StringBuilder mid = new StringBuilder();

        for (int i = 0; i < 26; i++) {

            for (int j = 0; j < freq[i] / 2; j++) {
                left.append((char) ('a' + i));
            }

            if (freq[i] % 2 == 1) {
                mid.append((char) ('a' + i));
            }
        }

        StringBuilder right = new StringBuilder(left).reverse();

        return left.toString() + mid.toString() + right.toString();
    }

    public static void main(String[] args) {

        System.out.println(smallestPalindrome("z"));       // z
        System.out.println(smallestPalindrome("babab"));   // abbba
        System.out.println(smallestPalindrome("daccad"));  // acddca
    }
}