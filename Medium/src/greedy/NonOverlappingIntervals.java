package greedy;

import java.util.Arrays;

public class NonOverlappingIntervals {
	public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        
        Arrays.sort(intervals, (a, b) -> (a[1] - b[1]));
        int count = 0;
        int prev = 0;
        
        for (int index = 1; index < intervals.length; index++) {
            int prevStart = intervals[prev][0];
            int prevEnd = intervals[prev][1];
            int currStart = intervals[index][0];
            int currEnd = intervals[index][1];
            
            if (prevEnd <= currStart) {
                prev = index;
            } else {
                if (prevEnd > currEnd) {
                    prev = index;
                }
                count++;
            }
        }
        
        return count;
    }

}
