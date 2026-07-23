import java.util.*;

public class PacificAtlanticWaterFlow {

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> result = new ArrayList<>();

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for (int col = 0; col < cols; col++) {
            dfs(heights, 0, col, pacific);
            dfs(heights, rows - 1, col, atlantic);
        }

        for (int row = 0; row < rows; row++) {
            dfs(heights, row, 0, pacific);
            dfs(heights, row, cols - 1, atlantic);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private static void dfs(int[][] heights, int row, int col, boolean[][] visited) {

        visited[row][col] = true;

        int[][] directions = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };

        for (int[] dir : directions) {

            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow < 0 || newRow >= heights.length ||
                newCol < 0 || newCol >= heights[0].length) {
                continue;
            }

            if (visited[newRow][newCol]) {
                continue;
            }

            if (heights[newRow][newCol] < heights[row][col]) {
                continue;
            }

            dfs(heights, newRow, newCol, visited);
        }
    }

    public static void main(String[] args) {

        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };

        System.out.println(pacificAtlantic(heights));
    }
}