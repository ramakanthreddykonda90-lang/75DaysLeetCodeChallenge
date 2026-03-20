class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int[] hash=new int[n];
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int maxi=0,idx=0;
        for(int i=1;i<n;i++)
        {
            hash[i]=i;
            for(int j=0;j<i;j++)
            {
                if(nums[i]%nums[j]==0&&1+dp[j]>dp[i])
                {
                    dp[i]=1+dp[j];
                    hash[i]=j;
                }
            }
            if(dp[i]>maxi)
            {
                maxi=dp[i];
                idx=i;
            }
        }
        List<Integer>ls=new ArrayList<>();
        while(idx!=hash[idx])
        {
            ls.add(nums[idx]);
            idx=hash[idx];
        }
        ls.add(nums[idx]);
        return ls;
    }
}