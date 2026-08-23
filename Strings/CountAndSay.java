

public class CountAndSay {
    public String countAndSay(int n) {
        if (n <= 0) return "";
        String result = "1";
        
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    sb.append(count).append(result.charAt(j - 1));
                    count = 1;
                }
            }
            sb.append(count).append(result.charAt(result.length() - 1));
            result = sb.toString();
        }
        
        return result;
    }

    // Main method to run and test locally in VS Code
    public static void main(String[] args) {
        Solution solver = new Solution();
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter value for n: ");
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            String output = solver.countAndSay(n);
            System.out.println("Output: \"" + output + "\"");
        } else {
            System.out.println("Please enter a valid integer.");
        }
        
        scanner.close();
    }
}