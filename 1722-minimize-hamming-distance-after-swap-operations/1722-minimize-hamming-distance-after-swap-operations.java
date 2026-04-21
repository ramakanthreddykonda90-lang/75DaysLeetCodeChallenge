class Solution {
    static class DSU{
        int[] parent;
        DSU(int n)
        {
            parent=new int[n];
            for(int i=0;i<n;i++)
            {
                parent[i]=i;
            }
        }
        public int find(int i)
        {
            if(i==parent[i])
            return i;
            return parent[i]=find(parent[i]);
        }
        public void union(int a,int b)
        {
            int parenta=find(a);
            int parentb=find(b);
            if(parenta!=parentb)
            parent[parentb]=parenta;
        }
    }
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n=source.length;
        DSU dsu=new DSU(n);
        for(int[] a:allowedSwaps)
        {
            dsu.union(a[0],a[1]);
        }
        Map<Integer,List<Integer>>mpp=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            int p=dsu.find(i);
            mpp.putIfAbsent(p,new ArrayList<>());
            mpp.get(p).add(i);
        }
        int ans=0;
        for(List<Integer>l:mpp.values())
        {
            Map<Integer,Integer>map=new HashMap<>();
            for(int idx:l)
            {
                map.put(source[idx],map.getOrDefault(source[idx],0)+1);
            }
            for(int idx:l)
            {
                if(map.getOrDefault(target[idx],0)>0)
                {
                    map.put(target[idx],map.get(target[idx])-1);
                }
                else
                ans++;
            }
        }
        return ans;
    }
}