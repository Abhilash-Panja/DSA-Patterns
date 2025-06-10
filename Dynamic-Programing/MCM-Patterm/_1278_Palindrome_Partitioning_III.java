//https://leetcode.com/problems/palindrome-partitioning-iii/
//Time O(N*K)+O(N*N)
import java.util.Arrays;
public class _1278_Palindrome_Partitioning_III {
  int[][]dp;
    int rec(int i,int K,String s,int[][]changes){
        if(K==0 && i< s.length()){
            return changes[i][s.length()-1];
        }
        if(i>=s.length()){
            return (int)1e9;
        }
        if(dp[i][K]!=-1){
            return dp[i][K];
        }
        int ans=Integer.MAX_VALUE;
        for(int k=i; k<s.length(); k++){
            ans=Math.min(ans,rec(k+1,K-1,s,changes)+changes[i][k]);
        }
        return dp[i][K]=ans;
    }
    public int palindromePartition(String s, int k) {
        int n=s.length();
        dp=new int[n][k];
        for(int[]arr: dp) Arrays.fill(arr,-1);
        int[][]changes=new int[n][n];
        for(int gap=1; gap<n; gap++){
            for(int i=0,j=gap; j<n; i++,j++){
                if(gap==1){
                    changes[i][j]=s.charAt(i)==s.charAt(j) ? 0 : 1;
                }
                else{
                    if(s.charAt(i)==s.charAt(j)){
                        changes[i][j]=changes[i+1][j-1];
                    }
                    else{
                        changes[i][j]=changes[i+1][j-1]+1;
                    }
                }
            }
        }
        for(int[]arr:changes){
            System.out.println(Arrays.toString(arr));
        }
        return rec(0,k-1,s,changes);
    }
}
