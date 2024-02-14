class Solution {
    public int[] rearrangeArray(int[] nums) {
         List<Integer> positiveNumbers = new ArrayList<>();
        List<Integer> negativeNumbers = new ArrayList<>();

        // Separate positive and negative numbers
        for (int num : nums) {
            if (num > 0) {
                positiveNumbers.add(num);
            } else {
                negativeNumbers.add(num);
            }
        }

        int[] result = new int[nums.length];
        int i = 0, j = 0, k = 0;

        // Interleave positive and negative integers with opposite signs
        while (i < positiveNumbers.size() && j < negativeNumbers.size()) {
            result[k++] = positiveNumbers.get(i++);
            result[k++] = negativeNumbers.get(j++);
        }

        // Append remaining positive or negative integers if any
        while (i < positiveNumbers.size()) {
            result[k++] = positiveNumbers.get(i++);
        }

        while (j < negativeNumbers.size()) {
            result[k++] = negativeNumbers.get(j++);
        }

        return result;
    }

}
