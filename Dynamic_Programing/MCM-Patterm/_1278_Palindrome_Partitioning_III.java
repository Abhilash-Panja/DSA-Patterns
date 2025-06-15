/*
----------------------------------------------------------------------------------------------------
                   Pattern Figure out
----------------------------------------------------------------------------------------------------
From the Question we can say that it fall on the MCM ,BCZ in this we are 
asked that to partion the String in such way that every substring should be Palindrome after
we partion.
And Here we asked Related to Partion the given String in to certain Substrings so it smells like
MCM were we have to partion the string in the arbitary point where we have to get the optimal answer.
----------------------------------------------------------------------------------------------------
                    Idea-1 T(N^4) + S(N^2)
----------------------------------------------------------------------------------------------------
So in this Approach we are Partioning the Substring at every arbitary point checking that by making
that can we able to get optimal answer.
state:DP[i][j]-->minimal number of characters that you need to change i--j
Transistions:for b=i to b<j where cost of i-->b + rec(b+1,j);
Doing for the every Partion to get minimal answer.
----------------------------------------------------------------------------------------------------
 Optimization of the Time in Idea-1 T(N^4) to T(N^3)
----------------------------------------------------------------------------------------------------
In this we have to Pre calculate the Minimum Character requried to change to make the palindrome
from the range i---j.
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
*/
class _1278_Palindrome_Partitioning_III {
    int getCost(int i,int j,String s){
        int count=0;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                count++;
            }
            i++;
            j--;
        }
        return count;
    }
    int MCM(int i,int j,int k,String s){
        if(i>=j) return 0;
        if(k==0){
            return getCost(i,j,s);
        }
        int ans=j-i+1;
        for(int b=i; b<j; b++){
            ans=Math.min(ans,getCost(i,b,s)+MCM(b+1,j,k-1,s));
        }
        return ans;
    }
    public int palindromePartition(String s, int k) {
        return MCM(0,s.length()-1,k-1,s);
    }
}