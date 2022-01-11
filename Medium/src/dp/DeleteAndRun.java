package dp;

public class DeleteAndRun {
	public int deleteAndEarn(int[] nums) {
		int count[] = new int[10001];
		for (int num : nums) {
			count[num]++;
		}

		int avoid = 0;
		int using = 0;
		int prev = -1;

		for (int curr = 0; curr <= 10000; curr++) {
			int freq = count[curr];
			if (freq > 0) {
				int value = freq * curr;
				int m = Math.max(using, avoid);
				if (prev == curr - 1) {
					using = value + avoid;
					avoid = m;
				} else {
					using = m + value;
					avoid = m;
				}
				prev = curr;
			}
		}

		return Math.max(using, avoid);
	}
}
