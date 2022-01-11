package graph;

import java.util.Arrays;

public class NearestZero {

	public int[][] updateMatrix(int[][] mat) {
        int[][] result = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            Arrays.fill(result[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    result[i][j] = 0;
                } else {
                    int left = j > 0 ? result[i][j - 1] : Integer.MAX_VALUE;
                    int up = i > 0 ? result[i - 1][j] : Integer.MAX_VALUE;
                    int min = Math.min(left, up);
                    if (min != Integer.MAX_VALUE) {
                        result[i][j] = min + 1;
                    }
                }
            }
        }
        
        for (int i = mat.length - 1; i >= 0; i--) {
            for (int j = mat[0].length - 1; j >= 0; j--) {
                if (mat[i][j] == 0) {
                    result[i][j] = 0;
                } else {
                    int right = j < result[0].length - 1 ? result[i][j + 1] : Integer.MAX_VALUE;
                    int down = i < result.length - 1 ? result[i + 1][j] : Integer.MAX_VALUE;
                    int min = Math.min(right, down);
                    if (min != Integer.MAX_VALUE) {
                        result[i][j] = Math.min(min + 1, result[i][j]);
                    }
                }
            }
        }
        
        return result;
    }
}
