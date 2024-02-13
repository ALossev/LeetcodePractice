class Solution {
    // Method to find the first palindrome in an array of words
    public String firstPalindrome(String[] words) {
        // Iterate through the array of words
        for (String word : words) {
            // Check if the current word is a palindrome
            if (isPalindrome(word)) {
                // If it is a palindrome, return the word
                return word;
            }
        }
        // If no palindrome is found, return an empty string
        return "";
    }

    // Method to check if a given string is a palindrome
    private boolean isPalindrome(String s) {
        // Initialize pointers for the start and end of the string
        int left = 0;
        int right = s.length() - 1;

        // Continue checking until the pointers meet in the middle
        while (left < right) {
            // If characters at the left and right positions are different, not a palindrome
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            // Move pointers towards the center
            left++;
            right--;
        }

        // If the loop completes without finding differences, the string is a palindrome
        return true;
    }
}
