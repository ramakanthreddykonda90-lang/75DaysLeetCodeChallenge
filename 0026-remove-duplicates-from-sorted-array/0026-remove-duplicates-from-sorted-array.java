class Solution {
    public int removeDuplicates(int[] nums) {
        int i,j,k;
        int size=nums.length;
        if(size==0)
        {
            return 0;
        }
       i=0;
       for(j=1;j<size;j++)
       {
        if(nums[j]!=nums[i])
        {
            nums[i+1]=nums[j];
            i++;
        }
       }
       return i+1;
    }
       
      
}