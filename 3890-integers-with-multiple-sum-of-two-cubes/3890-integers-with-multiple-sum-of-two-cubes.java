class Solution {
    public List<Integer> findGoodIntegers(int n) {
        List<Integer>l=new ArrayList<>();
        Set<Integer>st=new HashSet<>();
        HashMap<Integer,Integer>mpp=new HashMap<>();
        int right=(int)Math.pow(n,1.0/3.0)+1;
        //System.out.print(right+" ");
        int left=1;
       for(int i=left;i<=right;i++)
       {
        for(int j=i+1;j<=right;j++)
        {
            int res=((int)(Math.pow(i,3))+(int)(Math.pow(j,3)));
            //System.out.print(res+" ");
            if(res<=n)
            {
            mpp.put(res,mpp.getOrDefault(res,0)+1);
            if(mpp.get(res)>=2)
            st.add(res);
            }
        }
       }
       l.addAll(st);
       Collections.sort(l);
       return l;
    }
}