import java.util.*;
 
class Solution {
    public int numIslands(char[][] grid) {
        // Check if the grid is null or empty
        if (grid == null || grid.length == 0) {
            return 0;
        }
       
        // Get the number of rows and columns in the grid
        int rows = grid.length;
        int cols = grid[0].length;
   
        // Initialize a counter for the number of islands
        int nof_island = 0;
 
        // Iterate through each cell in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Check if the current cell is part of an island
                if (grid[i][j] == '1') {
                    // If yes, increment the island count and perform DFS to mark all connected cells
                    nof_island++;
                    dfs(grid, i, j);
                }
            }
        }
 
        // Return the total count of islands
        return nof_island;
    }
 
    // Depth-First Search (DFS) function to mark all connected cells as visited
    private void dfs(char[][] grid, int i, int j) {
        // Get the number of rows and columns in the grid
        int rows = grid.length;
        int cols = grid[0].length;
 
        // Check if the current cell is out of bounds or not part of an island
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] != '1') {
            return;
        }
 
        // Mark the current cell as visited
        grid[i][j] = '0';
 
        // Explore neighboring cells recursively
        dfs(grid, i + 1, j); // Down
        dfs(grid, i - 1, j); // Up
        dfs(grid, i, j + 1); // Right
        dfs(grid, i, j - 1); // Left
    }
}