class Solution {
    public static int parentNode(int a,int[] parent)
    {
        if(a==parent[a])
        return a;
        return parent[a]=parentNode(parent[a],parent);
    }
    public int makeConnected(int n, int[][] connections) {
        int[] parent=new int[n];
        for(int i=0;i<n;i++)
        {
            parent[i]=i;
        }
        int available=0;
        for(int[] mat:connections)
        {
            int x=mat[0];
            int y=mat[1];
            int parentx=parentNode(x,parent);
            int parenty=parentNode(y,parent);
            if(parentx==parenty)
            {
                available++;
                continue;
            }
            parent[parenty]=parentx;
        }
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            if(parent[i]==i)
            cnt++;
        }
        if(cnt>1+available)
        return -1;
        return cnt-1;
    }
}