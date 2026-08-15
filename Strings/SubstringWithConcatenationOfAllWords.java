import java.util.*;

public class SubstringWithConcatenationOfAllWords {

    public static List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();

        if (s == null || s.length() == 0 || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int wordCount = words.length;
        int totalLength = wordLength * wordCount;

        if (s.length() < totalLength) {
            return result;
        }

        HashMap<String, Integer> wordMap = new HashMap<>();

        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i <= s.length() - totalLength; i++) {

            HashMap<String, Integer> seenMap = new HashMap<>();

            int j = 0;

            while (j < wordCount) {

                int startIndex = i + j * wordLength;
                String currentWord = s.substring(startIndex, startIndex + wordLength);

                if (!wordMap.containsKey(currentWord)) {
                    break;
                }

                seenMap.put(currentWord, seenMap.getOrDefault(currentWord, 0) + 1);

                if (seenMap.get(currentWord) > wordMap.get(currentWord)) {
                    break;
                }

                j++;
            }

            if (j == wordCount) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        String s1 = "barfoothefoobarman";
        String[] words1 = {"foo", "bar"};

        String s2 = "wordgoodgoodgoodbestword";
        String[] words2 = {"word", "good", "best", "word"};

        String s3 = "barfoofoobarthefoobarman";
        String[] words3 = {"bar", "foo", "the"};

        System.out.println(findSubstring(s1, words1)); // [0, 9]
        System.out.println(findSubstring(s2, words2)); // []
        System.out.println(findSubstring(s3, words3)); // [6, 9, 12]
    }
}