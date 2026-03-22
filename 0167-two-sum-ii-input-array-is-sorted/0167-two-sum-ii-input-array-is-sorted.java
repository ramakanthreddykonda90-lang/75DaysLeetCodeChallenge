class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n=numbers.length;
        int left=0,right=n-1;
        int idx1=0,idx2=0;
        while(left<right)
        {
            if(numbers[left]+numbers[right]==target)
            {
                idx1=left+1;
                idx2=right+1;
                break;
            }
            else if(numbers[left]+numbers[right]>target)
            right--;
            else
            left++;
        }
        return new int[]{idx1,idx2};
    }
}