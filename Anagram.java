public class AnagramGrouping {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Create a hashmap to store the grouped anagrams
        Map<String, List<String>> map = new HashMap<>();

        // Iterate through each word in the array
        for (String word : strs) {
            // Convert the word to a char array and sort it
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);

            // Check if the sorted word is already in the hashmap
            if (!map.containsKey(sortedWord)) {
                // If not, add it as a new key with an empty list
                map.put(sortedWord, new ArrayList<>());
            }
            // Add the original word to the list corresponding to its sorted version
            map.get(sortedWord).add(word);
        }

        // Convert the values of the hashmap to a list and return
        return new ArrayList<>(map.values());
    }
