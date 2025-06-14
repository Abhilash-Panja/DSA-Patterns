import java.util.Arrays;
/* 
https://leetcode.com/problems/allocate-mailboxes/description/
*/
public class _1478_Allocate_Mailboxes {
Function minDistance(houses, k):
    Sort houses array      // So median is meaningful
    Initialize dp[n][k+1] to -1   // dp[i][k] = min cost to serve houses[i..n-1] with k mailboxes
    Return rec(0, n, k)    // Start from 0th house to n houses with k mailboxes


Function rec(i, j, k):
    If i >= j:
        Return INF      // Invalid range, no houses to serve
 
    If k == 1:
        // Base case: Only one mailbox, serve all houses in range [i..j-1]
        Return dp[i][k] = getCost(i, j-1)

    If dp[i][k] already computed:
        Return dp[i][k]

    Initialize ans = INF
    for kk=i to j-1:
        // Try placing 1st mailbox in [i..kk], solve remaining from kk+1..j with k-1 mailboxes
        currCost = getCost(i, kk)
        remainingCost = rec(kk + 1, j, k - 1)
        ans = min(ans, currCost + remainingCost)

    dp[i][k] = ans
    Return ans

/*
 We can optimize the getCost function to O(1) by precomputing the prefix sum 
 of houses array
 cost = new int[n][n];
        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {
                int median = start + (end - start) / 2;
                for (int m = start; m <= end; m++) {
                    cost[start][end] += Math.abs(houses[m] - houses[median]);
                }
            }
        }
*/
Function getCost(i, j):
    mid = (i + j) / 2
    cost = 0
    Loop from kk = i to j:
        cost += abs(houses[kk] - houses[mid])    // Distance from median
    Return cost
}
