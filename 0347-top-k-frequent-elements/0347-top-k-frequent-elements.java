
class Object
{
    int num;
    int cnt;
    Object(int num,int cnt)
    {
        this.cnt=cnt;
        this.num=num;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer>mpp=new HashMap<>();
        Set<Integer>st=new HashSet<>();
        int cnt=0;
        for(int i:nums)
        {
        mpp.put(i,mpp.getOrDefault(i,0)+1);
        }
        Object[] obj=new Object[mpp.size()];
        int j=0;
        for(int i:mpp.keySet())
        {
            obj[j++]=new Object(i,mpp.get(i));
        }
        Arrays.sort(obj,(a,b)->b.cnt-a.cnt);
        int[] ans=new int[k];
        for(int i=0;i<k;i++)
        ans[i]=obj[i].num;
        return ans;
    }
}