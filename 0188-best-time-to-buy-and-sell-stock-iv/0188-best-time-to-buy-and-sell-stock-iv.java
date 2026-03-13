class Solution {
    public static int f(int idx,int buy,int n,int k,int[] prices,int[][][] dp)
    {
        if(idx==n)
        return 0;
        if(k==0)
        return 0;
        if(dp[idx][buy][k]!=-1)
        return dp[idx][buy][k];
        if(buy==1)
        return dp[idx][buy][k]=Math.max(-prices[idx]+f(idx+1,0,n,k,prices,dp),f(idx+1,1,n,k,prices,dp));
        return dp[idx][buy][k]=Math.max(prices[idx]+f(idx+1,1,n,k-1,prices,dp),f(idx+1,0,n,k,prices,dp));
    }
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n][2][k+1];
        for(int[][] mat:dp)
        for(int[] a:mat)
        Arrays.fill(a,-1);
        return f(0,1,n,k,prices,dp);
    }
}