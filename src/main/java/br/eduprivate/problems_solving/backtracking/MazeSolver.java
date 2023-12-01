package br.eduprivate.problems_solving.backtracking;


import java.util.ArrayList;
import java.util.List;
// see geeksforgeeks

public class MazeSolver {

    // Initialize a string direction which represents all
    // the directions.
    private static final String direction = "DLRU";
    // Arrays to represent change in rows and columns
    private static final int[] dr = { 1, 0, 0, -1 };
    private static final int[] dc = { 0, -1, 1, 0 };

    // Function to check if cell(r, c) is inside the maze
    // and unblocked
    private static boolean isValid(int r, int c, int n,
                                   int[][] maze)
    {
        return r >= 0 && c >= 0 && r < n && c < n
                && maze[r][c] == 1;
    }

    // Function to get all valid paths
    private static void findPath(int r, int c, int[][] maze,
                                 int n, List<String> ans,
                                 StringBuilder currentPath)
    {

        // If we reach the bottom right cell of the matrix,
        // add the current path to ans and return
        if (r == n - 1 && c == n - 1) {
            ans.add(currentPath.toString());
            return;
        }

        // Mark the current cell as blocked
        maze[r][c] = 0;

        for (int i = 0; i < 4; i++) {
            // Find the next row based on the current row
            // (r) and the dr[] array
            int nextr = r + dr[i];
            // Find the next column based on the current
            // column (c) and the dc[] array
            int nextc = c + dc[i];
            // Check if the next cell is valid or not
            if (isValid(nextr, nextc, n, maze)) {
                currentPath.append(direction.charAt(i));
                // Recursively call the solve function for
                // the next cell
                findPath(nextr, nextc, maze, n, ans,
                        currentPath);
                currentPath.deleteCharAt(
                        currentPath.length() - 1);
            }
        }
        // Mark the current cell as unblocked
        maze[r][c] = 1;
    }

    public static void main(String[] args)
    {
        int n = 4;

        int[][] maze = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 1, 1, 0, 0 },
                { 0, 1, 1, 1 } };

        // List to store all the valid paths
        List<String> result = new ArrayList<>();

        // Store current Path
        StringBuilder currentPath = new StringBuilder();

        // Function call to get all valid paths
        findPath(0, 0, maze, n, result, currentPath);

        if (result.isEmpty())
            System.out.println(-1);
        else
            for (String path : result)
                System.out.print(path + " ");
        System.out.println();
    }
}
