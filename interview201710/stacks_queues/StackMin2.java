// single stack implementation
class StackMin2 {
    long min;
    Stack<Long> s;
    
    /** initialize your data structure here. */
    public MinStack() {
        min = 0L;
        s = new Stack<>();
    }
    
    public void push(int x) {
        if(s.isEmpty()) {
            s.push(0L);
            min = x;
        } else {
            s.push(x-min);
            if(min > x) min = x;
        }
    }
    
    public void pop() {
        if(s.isEmpty()) return;
        
        long val = s.pop();
        if(val < 0) min = min-val;
    }
    
    public int top() {
        return s.peek() < 0 ? (int)min : (int)(min+s.peek());
    }
    
    public int getMin() {
        return (int)min;
    }
}

// Node implementation
class StackMin2 {
    private Node head;
    
    public void push(int x) {
        if(head == null) 
            head = new Node(x, x);
        else 
            head = new Node(x, Math.min(x, head.min), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
    
    private class Node {
        int val;
        int min;
        Node next;
        
        private Node(int val, int min) {
            this(val, min, null);
        }
        
        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}
