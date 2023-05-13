class Solution {
  private int mod = (int) 1e9 + 7;
	private int helper(int index, int low, int high, int zero, int one, int[] dp) {
		if (index > high) {
			return 0;
		}
		if (dp[index] != -1) {
			return dp[index];
		}
		int waysIncludeZero = 0;
		int includeZero = index + zero;
		if (includeZero >= low && includeZero <= high) {
			waysIncludeZero = (1 + helper(includeZero, low, high, zero, one, dp));
		} else {
			waysIncludeZero = helper(includeZero, low, high, zero, one, dp);
		}
		int waysIncludeOne = 0;
		int includeOne = index + one;
		if (includeOne >= low && includeOne <= high) {
			waysIncludeOne = (1 + helper(includeOne, low, high, zero, one, dp));
		} else {
			waysIncludeOne = helper(includeOne, low, high, zero, one, dp);
		}
		return dp[index] = (waysIncludeZero + waysIncludeOne) % mod;
	}
	public int countGoodStrings(int low, int high, int zero, int one) {
		int[] dp = new int[high + Math.max(one, zero)];
		Arrays.fill(dp, -1);
		return helper(0, low, high, zero, one, dp);
	}
}