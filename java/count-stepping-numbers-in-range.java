class Solution {
private static final int mod = 1000000007;
    private long[][][][] dp;
    public int countSteppingNumbers(final String low, final String high) {
        resetArray();
        long result = solve(high, 0, -1, 1, 1);
        resetArray();
        result -= solve(low, 0, -1, 1, 1);
        result = (result + mod) % mod;
        int lowIsValid = getLowIsValid(low);
        result = (result + mod + lowIsValid) % mod;
        return (int) result;
    }
    private int getLowIsValid(final String low) {
        int lowIsValid = 1;
        for (int i = 1; i < low.length(); i++)
            if (Math.abs(low.charAt(i) - low.charAt(i - 1)) != 1) {
                lowIsValid = 0;
                break;
            }
        return lowIsValid;
    }
    private long solve(final String numString, int currentIndex, int previousDigit, int bound, int isZero) {
        if (numString.length() == currentIndex) return 1 - isZero;
        if (dp[currentIndex][previousDigit + 1][isZero][bound] != -1)
            return dp[currentIndex][previousDigit + 1][isZero][bound];
        long limit = numString.charAt(currentIndex) - '0';
        if (bound == 0) limit = 9;
        long ans = 0;
        for (int currentDigit = 0; currentDigit <= limit; currentDigit++) {
            int nextBound = (bound == 1 && currentDigit == limit) ? 1 : 0;
            int nextZero = (isZero == 1 && currentDigit == 0) ? 1 : 0;
            if (isZero == 1 || Math.abs(currentDigit - previousDigit) == 1)
                ans += (solve(numString, currentIndex + 1, currentDigit, nextBound, nextZero)) % mod;
        }
        return dp[currentIndex][previousDigit + 1][isZero][bound] = ans;
    }
    private void resetArray() {
        dp = new long[101][11][2][2];
        for (var i : dp) for (var j : i) for (var k : j) Arrays.fill(k, -1);
    }
}