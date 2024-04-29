class Solution {
    public int minOperations(int[] nums, int k) {
        int finalXor = 0;
        // Calculate the XOR of all integers in the array.
        for (int n : nums) {
            finalXor ^= n;
        }
        
        int count = 0;
        // Iterate until both k and finalXor become zero.
        while (k > 0 || finalXor > 0) {
            // Count the differing bits between k and finalXor.
            count += (k & 1) ^ (finalXor & 1);
            
            // Right shift to remove the least significant bit.
            k >>= 1;
            finalXor >>= 1;
        }
        
        return count;
    }
}
