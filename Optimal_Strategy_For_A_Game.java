public class Optimal_Strategy_For_A_Game {
  /* Recursive Approch*/
  int rec(int i,int j,int[]nums){
    if(i>j) return 0;
    if(i==j) return nums[i];
    if(i+1==j) Math.max(nums[i], nums[j]);
    //choosing the value from the starting
    int op1 = nums[i]+Math.min(rec(i+2,j,nums),rec(i+1,j-1,nums));
    //choosing the value from the ending
    int op2=nums[j]+Math.min(rec(i+1,j-1,nums), rec(i, j-2, nums));
    return Math.max(op1,op2);
  }  
  public int maximumAmount(int arr[]) { 
  /* Tabulation Approach*/
    //Time O(N^2)
        int n=arr.length;
        int[][]dp=new int[n][n];
        for(int gap=0; gap<n; gap++){
            for(int i=0,j=gap; j<n; i++,j++){
                if(i==j) dp[i][j]=arr[i];
                else if(i+1==j) dp[i][j]=Math.max(arr[i],arr[j]);
                else{
                    /*
                    What could be the reason taking the min of something
                    BCZ from our end we are playing in optimal way 
                    And where as in other our opponent also playing
                    optimally in worst case we may end up get as minimumn
                    as possible BCZ we thought that if He choose Optimally
                    we get as less value as possible so we are going to take
                    as worst as possible.
                    */
                    int op1=arr[i]+Math.min(dp[i+2][j],dp[i+1][j-1]);
                    int op2=arr[j]+Math.min(dp[i+1][j-1],dp[i][j-2]);
                    dp[i][j]=Math.max(op1,op2);
                }
            }
        }
        return dp[0][n-1];
    }
}
