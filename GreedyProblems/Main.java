
public class Main {
    public static String maxSumOfSquares(int num, int sum) {
        if ((long) num * 9 < sum) {
            return "";
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < num; i++) {
            int digit = Math.min(9, sum);
            ans.append(digit);
            sum -= digit;
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        int num = 2;
        int sum = 17;

        System.out.println(maxSumOfSquares(num, sum));
    }
}

