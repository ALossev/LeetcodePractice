class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        // Get the length of the input array
        int n = arr.length;
        
        // Create an array to store the maximum sum up to each index
        int[] dp = new int[n + 1];

        // Iterate through the array to calculate the maximum sum after partitioning
        for (int i = 1; i <= n; i++) {
            // Initialize maxVal to the minimum integer value
            int maxVal = Integer.MIN_VALUE;
            
            // Iterate through possible partition lengths (up to k and not exceeding the current index)
            for (int j = 1; j <= Math.min(k, i); j++) {
                // Update maxVal with the maximum value in the current partition
                maxVal = Math.max(maxVal, arr[i - j]);
                
                // Update the maximum sum at the current index based on the current partition
                dp[i] = Math.max(dp[i], dp[i - j] + maxVal * j);
            }
        }

        // The final element in the dp array contains the maximum sum after partitioning
        return dp[n];
    }
