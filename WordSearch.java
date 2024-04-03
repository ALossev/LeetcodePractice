public class Solution {
    
    // Main function to check if the word exists on the board
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        // Mark visited cells to avoid revisiting
        boolean[][] visited = new boolean[m][n];
        boolean result = false;
        
        // Iterate through each cell to start the search
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If the cell matches the first character of the word, start backtracking
                if (board[i][j] == word.charAt(0)) {
                    result = backtrack(board, word, visited, i, j, 0);
                    // If found, return true
                    if (result) return true;
                }
            }
        }
        
        // If not found, return false
        return false;
    }
    
    // Backtracking function to explore the neighboring cells
    private boolean backtrack(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
        // If all characters in the word are found, return true
        if (index == word.length()) {
            return true;
        }
        
        // Check for out of bounds or already visited cells or mismatched characters
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        
        // Mark the current cell as visited
        visited[i][j] = true;
        
        // Explore neighboring cells recursively
        if (backtrack(board, word, visited, i + 1, j, index + 1) ||
            backtrack(board, word, visited, i - 1, j, index + 1) ||
            backtrack(board, word, visited, i, j + 1, index + 1) ||
            backtrack(board, word, visited, i, j - 1, index + 1)) {
            return true;
        }
        
        // If the word is not found from the current cell, backtrack and mark it as unvisited
        visited[i][j] = false;
        return false;
    }
}
