class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0,right=0,maxLen=0;
        Set<Character>st=new HashSet<>();
        while(right<s.length())
        { 
          char ch=s.charAt(right);
          while(st.contains(ch))
          {
            st.remove(s.charAt(left));
            left++;
          }
          st.add(ch);
          maxLen=Math.max(maxLen,right-left+1);
          right++;
        }
        return maxLen;
        
    }
}