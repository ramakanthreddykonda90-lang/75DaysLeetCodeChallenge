class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       HashMap<String,List<String>>mpp=new HashMap<>();
       for(String s:strs)
       {
        char[] c=s.toCharArray();
        Arrays.sort(c);
        String res=new String(c);
        mpp.putIfAbsent(res,new ArrayList<>());
        mpp.get(res).add(s);
       } 
       List<List<String>>ans=new ArrayList<>();
        for(String a:mpp.keySet())
        {
            ans.add(mpp.get(a));
        }
        return ans;
       }
}