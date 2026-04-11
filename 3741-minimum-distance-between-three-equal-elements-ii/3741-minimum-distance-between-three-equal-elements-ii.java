class Solution {
    public int minimumDistance(int[] nums) {
        int ans=Integer.MAX_VALUE;
        int n=nums.length;
        Map<Integer,Integer>mpp1=new HashMap<>();
        Map<Integer,Integer>mpp2=new HashMap<>();
        Map<Integer,Integer>mpp3=new HashMap<>();
        for(int i=0;i<n;i++)
            {
               mpp1.put(nums[i],mpp1.getOrDefault(nums[i],0)+1);
                if(!mpp2.containsKey(nums[i]))
                {
                    mpp2.put(nums[i],i);
                }
                else if(!mpp3.containsKey(nums[i]))
                {
                    mpp3.put(nums[i],i);
                }
                else
                {
                    int key1=mpp2.get(nums[i]);
                    int key2=mpp3.get(nums[i]);
                    int maxi=Math.abs(key1-key2)+Math.abs(key2-i)+Math.abs(i-key1);
                    ans=Math.min(ans,maxi);
                    mpp2.put(nums[i],key2);
                    mpp3.put(nums[i],i);
                }
            }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}