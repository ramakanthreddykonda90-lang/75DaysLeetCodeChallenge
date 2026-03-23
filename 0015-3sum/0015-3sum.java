class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        List<List<Integer>>ls=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<n;i++)
        {
        if(i>0&&nums[i-1]==nums[i])
            continue;
        int left=i+1,right=n-1;
        while(left<right)
        {
            int sum=nums[left]+nums[right]+nums[i];
            if(sum==0)
            {
                ls.add(Arrays.asList(nums[i],nums[left],nums[right]));
                while(left<right&&nums[left]==nums[left-1])
                left++;
                while(left<right&&nums[right]==nums[right-1])
                right--;
            }
            if(sum<0)
            left++;
            else
            right--;
        }
        }
        return ls;
    }
}