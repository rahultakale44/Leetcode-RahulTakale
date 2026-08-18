public class CustomSortString {

    public static String customSortString(String order, String s) {

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder result = new StringBuilder();

        for (char ch : order.toCharArray()) {

            while (freq[ch - 'a'] > 0) {
                result.append(ch);
                freq[ch - 'a']--;
            }
        }

        for (int i = 0; i < 26; i++) {

            while (freq[i] > 0) {
                result.append((char) ('a' + i));
                freq[i]--;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        System.out.println(customSortString("cba", "abcd"));   // cbad
        System.out.println(customSortString("bcafg", "abcd")); // bcad
    }
}