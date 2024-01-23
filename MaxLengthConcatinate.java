class Solution {
    public int maxLength(List<String> arr) {
         return backtrack(0, "", arr);
    }

    private boolean isUnique(String subseq) {
        return subseq.length() == subseq.chars().distinct().count();
    }

    private int backtrack(int start, String current, List<String> arr) {
        int maxLength = isUnique(current) ? current.length() : 0;

        for (int i = start; i < arr.size(); i++) {
            maxLength = Math.max(maxLength, backtrack(i + 1, current + arr.get(i), arr));
        }

        return maxLength;
    }
}
