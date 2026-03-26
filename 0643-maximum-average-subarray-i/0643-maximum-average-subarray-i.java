class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double ans=-1000005;
        int n=nums.length;
        double sum=0;
        for(int i=0;i<k;i++)
        {
            sum+=nums[i];
        }
        ans=Math.max(ans,sum/k);
        System.out.print(ans+" ");
        for(int i=k;i<n;i++)
        {
            sum-=nums[i-k];
            sum+=nums[i];
            ans=Math.max(ans,sum/k);
        System.out.print(ans+" ");
        }
        return ans;
    }
}