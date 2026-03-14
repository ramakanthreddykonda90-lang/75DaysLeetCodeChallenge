class Solution {
    public boolean isAnagram(String s, String t) {
        int n1=s.length(),n2=t.length();
        if(n1!=n2)
        {
            return false;
        }
        char[] s1=s.toCharArray();
        char[] s2=t.toCharArray();
        int x=0,y=0;
        Arrays.sort(s1);
        Arrays.sort(s2);
        while(x<n1)
        {
            if(s1[x]!=s2[y])
            {
                return false;
            }
            x++;
            y++;
        }
        return true;
    }
}