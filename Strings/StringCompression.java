public class StringCompression {

    public static int compress(char[] chars) {

        int write = 0;
        int read = 0;

        while (read < chars.length) {

            char currentChar = chars[read];
            int count = 0;

            // Count consecutive repeating characters
            while (read < chars.length && chars[read] == currentChar) {
                read++;
                count++;
            }

            // Write the character
            chars[write] = currentChar;
            write++;

            // Write count only if greater than 1
            if (count > 1) {

                String countString = String.valueOf(count);

                for (char digit : countString.toCharArray()) {
                    chars[write] = digit;
                    write++;
                }
            }
        }

        return write;
    }

    public static void main(String[] args) {

        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};

        System.out.println("Original Array:");

        for (char ch : chars) {
            System.out.print(ch + " ");
        }

        int newLength = compress(chars);

        System.out.println("\n\nCompressed Array:");

        for (int i = 0; i < newLength; i++) {
            System.out.print(chars[i] + " ");
        }

        System.out.println("\n\nNew Length: " + newLength);
    }
}