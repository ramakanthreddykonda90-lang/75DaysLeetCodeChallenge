class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int[] preindx=new int[n];
        Arrays.fill(preindx,-1);
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty()&&temperatures[i]>temperatures[st.peek()])
            {
                preindx[st.pop()]=i;
            }
            st.push(i);
        }
        for(int i=0;i<n;i++)
        {
            if(preindx[i]==-1)
            preindx[i]=0;
            else
            preindx[i]=preindx[i]-i;
        }
        return preindx;
    }
}