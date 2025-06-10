class _1563_Stone_Game_V{
    int[][] dp;
    int[] prefix;
    /*Just Visualize the partion*/
    /*Calculating the Sum i to j using PrefixSum Concept*/
    int getSum(int i, int j, int[] stones) {
        int sum = 0;
        if (i > 0) {
            int left_Part = prefix[i - 1];
            int right_Part = prefix[j];
            sum = right_Part - left_Part;
            return sum;
        }
        return prefix[j];
    }

    /*
    Recursive Code:O(n^3)
    int rec(int i,int j,int[]stones){
        if(i+1==j) return Math.min(stones[i],stones[j]);
        if(i>=j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int ans=0;
        for(int k=i; k<=j-1; k++){
            int left=getSum(i,k,stones);
            int right=getSum(k+1,j,stones);
            if(left > right){
                ans=Math.max(ans,right+rec(k+1,j,stones));
            }
            else if(right > left){
                ans=Math.max(ans,left+rec(i,k,stones));
            }
            else{
                ans=Math.max(rec(i,k,stones),rec(k+1,j,stones))+left;
            }
        }
        return dp[i][j]=ans;
    
    -----------------------------------------------------------------------------------------------------
    Tabulation Code:
     public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        dp = new int[n][n];
        prefix = new int[n];
        prefix[0] = stoneValue[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = stoneValue[i] + prefix[i - 1];
        }
        for (int gap = 1; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; j++, i++) {
                if (gap == 1) {
                    dp[i][j] = Math.min(stoneValue[i], stoneValue[j]);
                } else {
                    int ans = 0;
                    for (int k = i; k <= j - 1; k++) {
                        int left = getSum(i, k, stoneValue);
                        int right = getSum(k + 1, j, stoneValue);
                        if (left > right) {
                            ans = Math.max(ans, right + dp[k + 1][j]);
                        } else if (right > left) {
                            ans = Math.max(ans, left + dp[i][k]);
                        } else {
                            ans = Math.max(dp[i][k], dp[k + 1][j]) + left;
                        }
                    }
                    dp[i][j] = ans;
                }
            }
        }
        return dp[0][n - 1];
    }
    
    */
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        dp = new int[n][n];
        prefix = new int[n];
        prefix[0] = stoneValue[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = stoneValue[i] + prefix[i - 1];
        }
        for (int gap = 1; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; j++, i++) {
                if (gap == 1) {
                    dp[i][j] = Math.min(stoneValue[i], stoneValue[j]);
                } else {
                    int ans = 0;
                    for (int k = i; k <= j - 1; k++) {
                        int left = getSum(i, k, stoneValue);
                        int right = getSum(k + 1, j, stoneValue);
                        if (left > right) {
                            ans = Math.max(ans, right + dp[k + 1][j]);
                        } else if (right > left) {
                            ans = Math.max(ans, left + dp[i][k]);
                        } else {
                            ans = Math.max(dp[i][k], dp[k + 1][j]) + left;
                        }
                    }
                    dp[i][j] = ans;
                }
            }
        }
        return dp[0][n - 1];
    }
}
