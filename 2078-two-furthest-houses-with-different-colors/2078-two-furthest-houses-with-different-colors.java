class Solution {
    public int maxDistance(int[] colors) {
        int n=colors.length;
        int l=0,r=n-1;
        int ans=0;
        while(l<r)
        {
            if(colors[l]!=colors[r])
            {
                ans=Math.max(ans,r-l);
                l++;
            }
            else
            r--;
        }
        l=0;
        r=n-1;
        while(l<r)
        {
            if(colors[l]!=colors[r])
            {
                ans=Math.max(ans,r-l);
                r--;
            }
            else
            l++;
        }
        return ans;
    }
}