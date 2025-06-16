package BinarySearch;
//https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
/*
---------------------------------------------------------------------------------------------
                 Pattern Figure out
----------------------------------------------------------------------------------------------
 In this we were asked to find out the minimum days to make the m bouquets, and here turns
 out to be something like minima-maxima calculation.so it would be fall under the BinarySearch.
 In Binary search also it falls under which catogoery Pattern something like 
 ->sweep
 ->Atomic item
 ->2D varient
 Current falls under sweep pattern BCZ we are enough foucused to check in contiguoes manner.
 Time:O(n*log(10^9));
 ---------------------------------------------------------------------------------------------
*/
public class _1482_Minimum_Number_of_Days_to_Make_m_Bouquets {
   int check(int day,int[]arr,int k,int m){
        int total_boquet=0;
        int i=0;
        int size=arr.length;
        int boquetSize=k;
        while(i<size && boquetSize<=size){
            while(i < boquetSize){
                //grouping the k consicutive flowers to make one boquet
                if(arr[i] <= day){
                    i++;
                }
                else{
                    //This means arr[i] flower yet blown at current day
                    break;
                }
            }
            if(i==boquetSize){
                total_boquet++;
                boquetSize+=k;
            }
            else{
                 i++;
                boquetSize=i+k;
            } 
        }
        return total_boquet >= m ? 1: 0;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int low=1;
        int high=(int)1e9;
        int ans=-1;
        int n=bloomDay.length;
        if(n < (m*k)){
            return -1;
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(check(mid,bloomDay,k,m)==1){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}
