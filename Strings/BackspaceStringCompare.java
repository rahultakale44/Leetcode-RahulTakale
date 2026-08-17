public class BackspaceStringCompare {

    public static boolean backspaceCompare(String s, String t) {

        String finalS = buildString(s);
        String finalT = buildString(t);

        return finalS.equals(finalT);
    }

    private static String buildString(String str) {

        StringBuilder sb = new StringBuilder();

        for (char ch : str.toCharArray()) {

            if (ch == '#') {

                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }

            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(backspaceCompare("ab#c", "ad#c")); // true
        System.out.println(backspaceCompare("ab##", "c#d#")); // true
        System.out.println(backspaceCompare("a#c", "b"));     // false
    }
}