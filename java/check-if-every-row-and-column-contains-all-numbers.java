class Solution {
public boolean checkValid(int[][] matrix) {
        for (int r = 0, n = matrix.length; r < n; ++r) {
            BitSet row = new BitSet(n + 1), col = new BitSet(n + 1);
            for (int c = 0; c < n; ++c) {
                if (row.get(matrix[r][c]) || col.get(matrix[c][r])) {
                    return false;
                }
                row.set(matrix[r][c]);
                col.set(matrix[c][r]);
            }
        } 
        return true;
    }
}