class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] pro=new int[n];
        int cnt=0;
        for(int i:nums)
        {
            if(i==0)
            cnt++;
        }
        if(cnt==1)
        {
            int idx=-1;
            int p=1;
            for(int i=0;i<n;i++)
            {
                if(nums[i]==0)
                {
                    idx=i;
                }
                else
                p=p*nums[i];
            }
            pro[idx]=p;
        }
        else if(cnt==0)
        {
            int p=1;
            for(int i=0;i<n;i++)
            {
                p*=nums[i];
            }
            for(int i=0;i<n;i++)
            {
                pro[i]=p/nums[i];
            }
        }
        return pro;
    }
}