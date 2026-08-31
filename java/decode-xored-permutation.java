class Solution {
public int[] decode(int[] encoded) {
        int first = 0;
        int n = encoded.length+1;
        for(int i=1;i<=n;i++){
            first ^= i; 
        }
        for(int i=1;i<n-1;i+=2) first ^= encoded[i];
        
        int[] perm = new int[n];
        perm[0] = first;
        for(int i=0;i<n-1;i++){
            perm[i+1] = perm[i] ^ encoded[i];
        }
        return perm;
    }
}