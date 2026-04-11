class Solution {
    public static boolean[] sieve()
    {
        boolean[] sie=new boolean[100015];
        Arrays.fill(sie,true);
        sie[1]=false;
        sie[0]=false;
        for(int i=2;i*i<sie.length;i++)
            {
                if(sie[i])
                {
                    for(int j=i*i;j<sie.length;j+=i)
                        {
                            sie[j]=false;
                        }
                }
            }
        return sie;
    }
    public static int[] val(boolean[] sie)
    {
        int n=sie.length;
        int[] idx=new int[n];
        Stack<Integer>st=new Stack<>();
        Arrays.fill(idx,-1);
        for(int i=0;i<n;i++)
            {
                while(!st.isEmpty()&&sie[i])
                    {
                        idx[st.pop()]=i;
                    }
                if(!sie[i])
                st.push(i);
            }
        while(!st.isEmpty())
            idx[st.pop()]=-1;
        return idx;
    }
    //  public static int[] val1(boolean[] sie)
    // {
    //     int n=sie.length;
    //     int[] idx=new int[n];
    //     Stack<Integer>st=new Stack<>();
    //     Arrays.fill(idx,-1);
    //     // idx[0]=2;
    //     // idx[1]=2;
    //     for(int i=2;i<n;i++)
    //         {
    //             while(!st.isEmpty()&&!sie[i])
    //                 {
    //                     idx[st.pop()]=i;
    //                 }
    //             if(sie[i])
    //             st.push(i);
    //         }
    //     while(!st.isEmpty())
    //         idx[st.pop()]=-1;
    //     return idx;
    // }
    public int minOperations(int[] nums) {
        boolean[] sieve=sieve();
        // for(int i=0;i<sieve.length;i++)
        //     System.out.print(sieve[i]+" ");
        int[] idx=val(sieve);
        // for(int i=0;i<idx.length;i++)
        //     {
        //         System.out.print(idx[i]+" ");
        //     }
        int ans=0;
        //int[] val1=val1(sieve);
        for(int i=0;i<nums.length;i++)
            {
                if(i%2==0&&!sieve[nums[i]])
                {
                    if(idx[nums[i]]!=-1)
                    ans+=idx[nums[i]]-nums[i];
                }
                else if(i%2!=0&&sieve[nums[i]])
                   if(nums[i]==2)
                   ans+=2;
                   else ans+=1;
                //System.out.print(ans+" ");
            }
        return ans;
    }
}