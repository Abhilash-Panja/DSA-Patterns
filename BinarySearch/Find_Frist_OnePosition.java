package BinarySearch;
/*
 In this Question we have Provided an Binary Array consisting of sarting with
 0's and followed by 1's. We have to find the first 1 in the array.
 ------------------------------------------------------------------------------
  Intution-1:
 ------------------------------------------------------------------------------
  If we found any any 1 position inthe array it means to its right we can say
  that Definetly we consists only 1's , so we are bothered about the 1 position 
  of the 1. And what ever we are standing it may frist or may not so to figure
  out we move as left as possible even we finding the 1 position in mid.

  Check Method:
  if(arr[mid]==1){
    return 1;
  }
  else{
  return 0;
  }
  
*/
public class Find_Frist_OnePosition {
  public int check(int arr[],int mid){
    if(arr[mid]==1){
      return 1;
    }
    else{
      return 0;
    }
  }
  public int Find(int arr[],int n){
    int low=0,high=n-1;
    int ans=-1;
    while(low<=high){
      int mid=low+(high-low)/2;
      if(check(arr,mid)==1){
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
