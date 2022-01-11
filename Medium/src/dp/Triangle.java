package dp;

import java.util.Collections;
import java.util.List;

public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
        for (int row = 1; row < triangle.size(); row++) {
            for (int col = 0; col < triangle.get(row).size(); col++) {
                int smallestAbove = Integer.MAX_VALUE;
                if (col == 0) {
                    smallestAbove = triangle.get(row - 1).get(0);
                } else if (col == triangle.get(row).size() - 1) {
                    smallestAbove = triangle.get(row - 1).get(triangle.get(row - 1).size() - 1);
                } else {
                    smallestAbove = Math.min(triangle.get(row - 1).get(col - 1),
                                            triangle.get(row - 1).get(col));
                }
                int current = triangle.get(row).get(col);
                triangle.get(row).set(col, current + smallestAbove);
            }
        }
        
        List<Integer> lastRow = triangle.get(triangle.size() - 1);
        Collections.sort(lastRow);
        return lastRow.get(0);
    }
}
