class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;  // Initialize count for subarrays with sum equal to goal
        Map<Integer, Integer> prefixSum = new HashMap<>();  // Initialize a map to store prefix sums and their counts
        int currSum = 0;  // Initialize current sum

        for (int num : nums) {
            currSum += num;  // Increment current sum by the current element

            // If the current sum is equal to the goal, increment count
            if (currSum == goal) {
                count++;
            }

            // If the current sum minus the goal exists in prefixSum, add its count to the total count
            if (prefixSum.containsKey(currSum - goal)) {
                count += prefixSum.get(currSum - goal);
            }

            // Increment the count of current sum in prefixSum map
            prefixSum.put(currSum, prefixSum.getOrDefault(currSum, 0) + 1);
        }

        return count;
    }
}
