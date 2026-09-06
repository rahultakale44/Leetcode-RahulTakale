import java.util.*;

public class GenerateParentheses {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        backtrack(result, new StringBuilder(), 0, 0, n);

        return result;
    }

    private static void backtrack(List<String> result,
                                  StringBuilder current,
                                  int open,
                                  int close,
                                  int n) {

        if (open == n && close == n) {
            result.add(current.toString());
            return;
        }

        // Add '('
        if (open < n) {
            current.append('(');

            backtrack(result, current, open + 1, close, n);

            // Backtrack
            current.deleteCharAt(current.length() - 1);
        }

        // Add ')'
        if (close < open) {
            current.append(')');

            backtrack(result, current, open, close + 1, n);

            // Backtrack
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        List<String> result = generateParenthesis(n);

        System.out.println("Output: " + result);

        sc.close();
    }
}

