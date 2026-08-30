class Solution {
    public int distinctIntegers(int n) {
        Set<Integer> board = new HashSet<>();
        board.add(n);
        
        int size = board.size();
        while (true) {
            for (int i = 1; i < n; i++) {
                for (int x : new ArrayList<>(board)) {
                    if (x % i == 1) board.add(i);
                }
            }
            if (size == board.size()) break;
            size = board.size();
        }

        return size;
    }
}