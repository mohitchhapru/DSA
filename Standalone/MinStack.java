/**
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * 
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 * 
 */

class MinStack {
    Stack<Integer> stack1,stack2;
    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int x) {
        stack1.push(x);
        if(stack2.isEmpty())
            stack2.push(x);
        else{
           if(x<=stack2.peek())
               stack2.push(x);
        }
    }
    
    public void pop() {
        if(!stack1.isEmpty()){
            int x = stack1.pop();
            if(x == stack2.peek())
                stack2.pop();
                
        }            
    }
    
    public int top() {
        return stack1.peek();
    }
    
    public int getMin() {
        return stack2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */