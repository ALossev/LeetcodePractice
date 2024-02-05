import java.util.HashMap;

public class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> charFrequencyMap = new HashMap<>();

        // Count the frequency of each character in the string
        for (char ch : s.toCharArray()) {
            charFrequencyMap.put(ch, charFrequencyMap.getOrDefault(ch, 0) + 1);
        }

        // Find the index of the first unique character
        for (int i = 0; i < s.length(); i++) {
            if (charFrequencyMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        // If no unique character is found
        return -1;
    }
}
