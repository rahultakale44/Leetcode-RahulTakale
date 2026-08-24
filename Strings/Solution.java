
public class Solution {
    public int longestPalindrome(String s) {
       
        int[] charCounts = new int[128];
        for (char c : s.toCharArray()) {
            charCounts[c]++;
        }
        
        int length = 0;
        boolean hasOddCount = false;
        
        for (int count : charCounts) {
            
            length += (count / 2) * 2;
            
            
            if (count % 2 != 0) {
                hasOddCount = true;
            }
        }
        
        
        if (hasOddCount) {
            length += 1;
        }
        
        return length;
    }

    
    public static void main(String[] args) {
        Solution solver = new Solution();

       
        String test1 = "abccccdd";
        System.out.println("Input: " + test1);
        System.out.println("Output: " + solver.longestPalindrome(test1)); // Expected: 7
        System.out.println();

        
        String test2 = "a";
        System.out.println("Input: " + test2);
        System.out.println("Output: " + solver.longestPalindrome(test2)); // Expected: 1
    }
}