import java.util.Arrays;

public class _1547_Minimum_Cost_to_Cut_a_Stick {
    int rec(int i,int j,int[]cuts){
        if(i+1==j){
            return 0;
        }
        int ans=(int)1e9;
        for(int k=0; k<cuts.length; k++){
            if (cuts[k] <= i || cuts[k] >= j) continue;
            int cost=j-i;
            int left=rec(i,cuts[k],cuts);
            int right=rec(cuts[k],j,cuts);
            ans=Math.min(ans,cost+left+right);
        }
        return ans;
    }
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        return rec(0,n,cuts);
    }
    public static void main(String[] args) {
      _1547_Minimum_Cost_to_Cut_a_Stick s=new _1547_Minimum_Cost_to_Cut_a_Stick();
      int n=7;
      int []cuts={1,3,4,5};
      System.out.println(s.minCost(n,cuts));
    }
}

