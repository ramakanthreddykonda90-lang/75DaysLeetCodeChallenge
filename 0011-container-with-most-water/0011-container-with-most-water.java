class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int ans=0;
       int low=0,high=n-1;
       while(low<high)
       {
        int l=Math.min(height[low],height[high]);
        int b=high-low;
        ans=Math.max(ans,l*b);
        if(height[low]<=height[high])
        low++;
        else
        high--;
       }
        return ans;
    }
}