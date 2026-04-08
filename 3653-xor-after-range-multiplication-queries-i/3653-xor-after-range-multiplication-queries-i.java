class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int mod=1_000_000_007;
        int n=queries.length;
        int m=nums.length;
        for(int i=0;i<n;i++)
        {
            int idx=queries[i][0];
            int r=queries[i][1];
            int k=queries[i][2];
            int val=queries[i][3];
            while(idx<=r)
            {
               nums[idx] = (int)(((long)nums[idx] * val) % mod);
                idx += k;
            }
        }
        int res=0;
        for(int i:nums)
        {
            res^=i;
        }
        return res;
    }
}