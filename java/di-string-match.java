class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int low = 0;
        int high = n;

        int[] arr = new int[n+1];

        for(int i=0; i<n; i++){
            if(s.charAt(i) == 'I'){
                arr[i] = low++;
            }else {
                arr[i] = high--;
            }
        }
        arr[n] = high;
        return arr;
    }
}