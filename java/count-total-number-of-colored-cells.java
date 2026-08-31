class Solution {
    public long coloredCells(int n) {
        if(n==1)
            return 1l;
        long x=1;
        long i=1;
        while(n-->1){
            x+=(i*4l);
            i++;
        }
        return x;
    }
}