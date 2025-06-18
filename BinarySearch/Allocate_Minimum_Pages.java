package BinarySearch;

import java.util.Arrays;

/*
https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1


----------------------------------------------------------------------------------------------
                 What Mistake I made in this solution? At first Glance
----------------------------------------------------------------------------------------------
1.OverConfidently tried to attempt the Question without reading the problem statement carefully.
2.Over looked the Statement that Every student must get at least one book.
3.From point 2 figuring out the edge case where number of students greater than the given length
of the array means where point 2 would be failed.
----------------------------------------------------------------------------------------------
                 Pattern Figure out     Time:O(N*Log(sum of (Array)))
----------------------------------------------------------------------------------------------
We are given an array of Books which represts the number of pages in each book and we are
asked to allocate the books in such way every student get atleast one book and get the 
maximum of the minimum number of books each student get.

And when we read the question carefully we were asked to figure out the maxima of minima
And this falls under the BinarySearch.
And In BinarySearch it falls under the BinarySearch on Answer And in BinarySearch on Answer
it falls under sweep method BCZ we are Dealing with the Contiguoes Block in the check function
------------------------------------------------------------------------------------------------
*/
public class Allocate_Minimum_Pages {
  static int check(int mid,int[]arr,int k){
        int curr_Pages_left=0;
        int curr_student_count=0;
        int n=arr.length;
        for(int i=0;i<n; i++){
            if(arr[i] <= curr_Pages_left){
                curr_Pages_left-=arr[i];
            }
            else{
                curr_student_count++;
                curr_Pages_left=mid;
                if(arr[i] <= curr_Pages_left){
                    curr_Pages_left-=arr[i];
                }
                else{
                    return 0;
                }
                  
                
            }
        }
        return curr_student_count<=k ? 1: 0;
    }
    public static int findPages(int[] arr, int k) {
        // code here
        int n=arr.length;
        if(n<k){
            return -1;
        }
        int lo=1;
        int hi=Arrays.stream(arr).sum();
        int ans=-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(check(mid,arr,k)==1){
                ans=mid;
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return ans;
    }
}
