class Solution {
public int[] closestDivisors(int num) {
        int[] res = {1, num + 1};
        int min = num;
        for (int n : new int[]{num + 1, num + 2}) {
            int d = (int)Math.floor(Math.sqrt(n)); 
            while (d > 0 && n % d != 0) {--d; }
            if (min > n / d - d) {
                min = n / d - d;
                res = new int[]{n / d, d};
            } 
        }
        return res;        
    }
}