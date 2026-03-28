public class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int maxLen = 0;
        int maxFreq = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            // Update frequency of the current character
            char currentChar = s.charAt(right);
            count[currentChar - 'A']++;
            
            // Track the most frequent character in the current window
            maxFreq = Math.max(maxFreq, count[currentChar - 'A']);

            // If (window size - most frequent char count) > k, it's invalid
            // We need to shrink the window from the left
            while ((right - left + 1) - maxFreq > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            // Update the global maximum length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}