class MinStack {
     private Stack<Integer>st;
     private Stack<Integer>st1;
    public MinStack() {
        st=new Stack<>();
        st1=new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(st1.isEmpty()||st1.peek()>=val)
        st1.push(val);
    }
    
    public void pop() {
       if(st.peek().equals(st1.peek()))
       {
        st.pop();
        st1.pop();
       }
       else
       st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return st1.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */