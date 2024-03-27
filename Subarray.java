class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
                if (k <= 1) return 0; // If k is less than or equal to 1, no subarray will have a product less than k
        
        int count = 0;
        int product = 1;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            product *= nums[right]; // Expand the window by multiplying the product with the new element
            
            // Shrink the window from the left if product is greater than or equal to k
            while (product >= k) {
                product /= nums[left];
                left++;
            }
            
            // Every time we expand the window, count the subarrays
            count += right - left + 1;
        }

        return count;
    }
    }
