package tag.array;

/**
 * Created by he.dong on 10/9/2017.
 */
public class _695_MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int col = 0;
        int row = grid.length;
        if (row == 0 || grid[0].length == 0)
            return 0;
        else
            col = grid[0].length;

        int[][] processed = new int[row][col];
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    int area = getArea(grid, i, j, processed);
                    if (max < area)
                        max = area;
                }
            }
        }
        return max;
    }

    public int getArea(int[][] grid, int i, int j, int[][] processed) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0)
            return 0;
        if (processed[i][j] == 1) {
            return 0;
        }
        processed[i][j] = 1;
        return 1 + getArea(grid, i + 1, j, processed) + getArea(grid, i, j + 1, processed) +
                getArea(grid, i - 1, j, processed) + getArea(grid, i, j - 1, processed);
    }

    public static void main(String[] args) {
        System.out.println(
            new _695_MaxAreaOfIsland().maxAreaOfIsland(new int[][]{
                    {0,1},{1,1}
        }));

    }
}
