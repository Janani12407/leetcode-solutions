class Solution {
    int [][][]dp;
    public int minimizeConcatenatedLength(String[] words) {
        int n = words.length;

        int total = 0;
        for(int i = 0; i < n; i++){
            total += words[i].length();
        }

        dp = new int[n+1][26][26];
        for(int [][]ar : dp){
            for(int []ele : ar){
                    Arrays.fill(ele, -1);
            }
        }

        return total - solve(1, words[0].charAt(0), words[0].charAt(words[0].length() - 1), words);
    }
    public int solve(int idx, char start, char end, String []words){
        if(idx >= words.length){
            return 0;
        }

        if(dp[idx][start - 'a'][end - 'a'] != -1){
            return dp[idx][start - 'a'][end - 'a'];
        }

        int ans = (int)1e8;
        
        // stri = join(stri - 1, words[i])
        if(end == words[idx].charAt(0)){
            ans = 1 + solve(idx + 1, start, words[idx].charAt(words[idx].length() - 1), words);
        }
        else{
            ans = solve(idx + 1, start, words[idx].charAt(words[idx].length() - 1), words);
        }

        // stri = join(words[i], stri - 1)
        if(words[idx].charAt(words[idx].length() - 1) == start){
            ans = Math.max(ans, 1 + solve(idx + 1, words[idx].charAt(0), end, words));
        }
        else{
            ans = Math.max(ans, solve(idx + 1, words[idx].charAt(0), end, words));
        }

        return dp[idx][start - 'a'][end - 'a'] = ans;
    }
}