/*https://leetcode.com/problems/stone-game-v/description*/
class _1563_Stone_Game_V{
    function rec(i, j, stones):
        if i + 1 == j:
            return min(stones[i], stones[j])  // base case: only two stones

        if i >= j:
            return 0  // invalid range, no score

        if dp[i][j] is already computed:
            return dp[i][j]

        maxScore = 0

        for k from i to j-1:  // try all split points
            leftSum = getSum(i, k, stones)
            rightSum = getSum(k+1, j, stones)

            if leftSum > rightSum:
                // choose right part and add its sum
                maxScore = max(maxScore, rightSum + rec(k+1, j, stones))
            else if rightSum > leftSum:
                // choose left part and add its sum
                maxScore = max(maxScore, leftSum + rec(i, k, stones))
            else:
                // equal: choose the best of both
                maxScore = max(maxScore, max(rec(i, k, stones), rec(k+1, j, stones)) + leftSum)

    dp[i][j] = maxScore
    return maxScore
    public int stoneGameV(int[] stoneValue) {
       return function(0,stoneValue.length-1,stoneValue);

    }
}
