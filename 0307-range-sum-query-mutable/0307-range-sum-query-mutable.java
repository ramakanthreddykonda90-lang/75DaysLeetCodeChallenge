class NumArray {
    static int[] seg;
    public static void  buildTree(int idx,int low,int high,int[] nums)
    {
        if(low==high)
        {
            seg[idx]=nums[low];
            return;
        }
        int mid=low+(high-low)/2;
        buildTree(2*idx+1,low,mid,nums);
        buildTree(2*idx+2,mid+1,high,nums);
        seg[idx]=seg[2*idx+1]+seg[2*idx+2];
    }
    public NumArray(int[] nums) {
        int n=nums.length;
        seg=new int[4*n];
        buildTree(0,0,n-1,nums);
    }
    public static void  updateTree(int idx,int low,int high,int index,int val)
    {
        if(low==high)
        {
            seg[idx]=val;
            return;
        }
        int mid=low+(high-low)/2;
        if(index>=low&&index<=mid)
        {
            updateTree(2*idx+1,low,mid,index,val);
        }
        else
         updateTree(2*idx+2,mid+1,high,index,val);
        seg[idx]=seg[2*idx+1]+seg[2*idx+2];
    }
    public void update(int index, int val) {
        int n=seg.length/4;
        updateTree(0,0,n-1,index,val);
    }
    public static int range(int idx,int low,int high,int l,int r)
    {
        if(low>r||high<l)
        return 0;
        if(low>=l&&high<=r)
        return seg[idx];
        int mid=low+(high-low)/2;
        return range(2*idx+1,low,mid,l,r)+range(2*idx+2,mid+1,high,l,r);
    }
    public int sumRange(int left, int right) {
        int n=seg.length/4;;
        return range(0,0,n-1,left,right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */