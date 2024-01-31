import java.util.Stack;

public class Solution {

    // Function to find the daily temperatures
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Iterate through the temperatures
        for (int i = 0; i < n; i++) {
            // Check if the current temperature is greater than the temperature at the top of the stack
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                // If true, update the result for the index at the top of the stack
                int prevDay = stack.pop();
                result[prevDay] = i - prevDay;
            }

            // Push the current index onto the stack
            stack.push(i);
        }

        // The result array contains the number of days to wait for a warmer temperature for each day
        return result;
    }

    // Main method for testing the solution
    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        Solution solution = new Solution();
        int[] result = solution.dailyTemperatures(temperatures);

        // Print the result
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
