public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] arr = new int[] { 1,2,3,5,2,3,1 };
        
    }
    
    public static int findLargestRectangle(int[] arr) {
        int max = Integer.MIN_VALUE;
        Stack<Integer> pStack = new Stack<>();
        Stack<Integer> hStack = new Stack<>();
        
        for(int i = 0; i < arr.length; i++) {
            int currHeight = arr[i];
            if(pStack.isEmpty() || hStack.peek() <= currHeight) {
                pStack.push(i);
                hStack.push(currHeight);
            } else {
                while(!hStack.isEmpty() && hStack.peek() > currHeight)
                    max = Math.max(max, hStack.pop() * (i-pStack.pop());
                if(pStack.isEmpty()) {
                    pStack.push(i);
                    hStack.push(currHeight);
                }
            }
        }
        
        while(!hStack.isEmpty())
            max = Math.max(max, hStack.pop() * (arr.length-1 - pStack.pop());
        return max;
    }
}
