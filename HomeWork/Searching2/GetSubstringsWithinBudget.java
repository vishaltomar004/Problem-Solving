package HomeWork.Searching2;

public class GetSubstringsWithinBudget {
    public int equalSubstring(String s, String t, int maxCost) {
        int[] a = new int[s.length()];
        char[] f = s.toCharArray();
        char[] s1 = t.toCharArray();
        
        // Calculate absolute differences
        for (int i = 0; i < f.length; i++) {
            a[i] = Math.abs(f[i] - s1[i]);
        }
        
        int l = 0;
        int r = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
    
        while (l < a.length && r < a.length) {
            sum += a[r];
            
            // Check if the sum exceeds maxCost
            while (sum > maxCost) {
                // Update max with the length of the current substring
                max = Math.max(max, r - l);
    
                // Subtract the absolute difference at the left pointer
                sum -= a[l];
                // Move the left pointer to the right
                l++;
            }
    
            // Move the right pointer to the right
            r++;
        }
    
        // Update max one last time in case the substring reaches the end
        max = Math.max(max, r - l);
    
        return max;
    }
}
