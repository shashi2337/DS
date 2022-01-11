package graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

	public int orangesRotting(int[][] grid) {
        int numberOfGoodOranges = 0;
        Queue<Pair> queue = new LinkedList();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    numberOfGoodOranges++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new Pair(i, j));
                }
            }
        }
        queue.offer(new Pair(-1, -1));
        
        int minutesElapsed = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            if (curr.X == -1) {
                if (!queue.isEmpty()) {
                    queue.offer(new Pair(-1, -1));
                    minutesElapsed++;
                }
            } else {
                int newRow;
                int newColumn;
                for (int[] direction : directions) {
                    newRow = curr.X + direction[0];
                    newColumn = curr.Y + direction[1];
                    if (newRow < 0 || newRow >= grid.length || newColumn < 0 || newColumn >= grid[0].length) {
                        continue;
                    }
                    if (grid[newRow][newColumn] == 1) {
                        numberOfGoodOranges--;
                        grid[newRow][newColumn] = 2;
                        queue.offer(new Pair(newRow, newColumn));
                    }
                }
            }
        }
        
        return numberOfGoodOranges == 0 ? minutesElapsed : -1;
    }
}


class Pair {
    public int X;
    public int Y;
    
    public Pair(int x, int y) {
        X = x;
        Y = y;
    }
}