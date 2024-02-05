class Solution {
    public String minWindow(String s, String t) {
        // Initialize maps to track characters and their counts
        Map<Character, Integer> requiredChars = new HashMap<>();
        Map<Character, Integer> formedChars = new HashMap<>();

        // Initialize requiredChars map with characters and their counts from string t
        for (char c : t.toCharArray()) {
            requiredChars.put(c, requiredChars.getOrDefault(c, 0) + 1);
        }

        // Initialize pointers and variables for the sliding window
        int left = 0, right = 0;
        int requiredCharsCount = requiredChars.size();
        int minLen = Integer.MAX_VALUE;
        int minWindowStart = -1;

        // Iterate through the string s using the sliding window approach
        while (right < s.length()) {
            // Expand the window to the right
            char currentChar = s.charAt(right);
            formedChars.put(currentChar, formedChars.getOrDefault(currentChar, 0) + 1);

            // Check if the current character completes a required character in the window
            if (requiredChars.containsKey(currentChar) && formedChars.get(currentChar).equals(requiredChars.get(currentChar))) {
                requiredCharsCount--;
            }

            // Contract the window from the left
            while (requiredCharsCount == 0) {
                // Update the minimum window if a smaller one is found
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minWindowStart = left;
                }

                // Contract the window from the left
                char leftChar = s.charAt(left);
                formedChars.put(leftChar, formedChars.get(leftChar) - 1);

                // Check if the contraction affects a required character in the window
                if (requiredChars.containsKey(leftChar) && formedChars.get(leftChar) < requiredChars.get(leftChar)) {
                    requiredCharsCount++;
                }

                left++;
            }

            // Expand the window to the right
            right++;
        }

        // Return the result substring or an empty string if no valid window is found
        return minWindowStart == -1 ? "" : s.substring(minWindowStart, minWindowStart + minLen);
    }
