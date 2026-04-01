class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String>st=new Stack<>();
        for(String s:tokens)
        {
            if(s.equals("+")||s.equals("*")||s.equals("-")||s.equals("/"))
            {
                if(st.size()>1)
                {
                    String r11=st.pop();
                    String r12=st.pop();
                    int r1=Integer.parseInt(r11);
                    int r2=Integer.parseInt(r12);
                    int res=0;
                    if(s.equals("+"))
                    {
                        res=r1+r2;
                    }
                    else if(s.equals("-"))
                    {
                        res=r2-r1;
                    }
                    else if(s.equals("*"))
                    {
                        res=r1*r2;
                    }
                    else if(s.equals("/"))
                    {
                        res=r2/r1;
                    }
                    st.push(String.valueOf(res));
                }
            }
            else
            st.push(s);
            System.out.print(st.peek()+" ");
        }
        return (int)(Integer.parseInt(st.peek()));
    }
}