#include <vector>
#include <algorithm> // for sort

class Solution {
public:
    vector<vector<int>> divideArray(vector<int>& nums, int k) {
        int size = nums.size();

        // Sort the input array in ascending order
        sort(nums.begin(), nums.end());

        // Initialize the result vector with the number of expected groups and each group having 3 elements
        vector<vector<int>> result(size / 3, vector<int>(3));
        int groupIndex = 0;

        // Iterate through the sorted array in steps of 3
        for (int i = 0; i < size; i += 3) {
            // Check if there are at least 3 elements remaining in the array and the difference between the first and last element is less than or equal to k
            if (i + 2 < size && nums[i + 2] - nums[i] <= k) {
                // Assign the current group with the three elements from the current position
                result[groupIndex] = { nums[i], nums[i + 1], nums[i + 2] };
                groupIndex++;
            } else {
                // If the conditions are not met, return an empty vector (impossible to satisfy conditions)
                return vector<vector<int>>();
            }
        }

        // Return the resulting 2D vector containing arrays satisfying the conditions
        return result;
    }
};
