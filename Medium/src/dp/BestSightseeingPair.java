package dp;

public class BestSightseeingPair {
	public int maxScoreSightseeingPair(int[] values) {
        int max = 0;
        int jIndex = values[0] - 0;
        
        for (int i = 1; i < values.length; i++) {
            int curr = values[i] - i + jIndex;
            max = Math.max(max, curr);
            jIndex = Math.max(jIndex, values[i] + i);
        }
        
        return max;
    }
}
