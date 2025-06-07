class Solution{
    static int[][]dp;
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        dp=new int[101][101];
        for(int[]x: dp){
            Arrays.fill(x,-1);
        }
        return f(arr,1,N-1);
    }
    static int f(int[]arr,int i, int j){
        //base
        if(i>=j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=(int)1e9;
        for(int k=i; k<j; k++){
            int temp=(arr[i-1]*arr[k]*arr[j])+f(arr,i,k)+f(arr,k+1,j);
            ans=Math.min(ans,temp);
        }
        return dp[i][j]=ans;
    }
}