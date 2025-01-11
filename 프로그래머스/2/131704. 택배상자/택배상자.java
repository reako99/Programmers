import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> belt = new Stack<>();
        int result = 0;
        for(int i = 1 ; i <= order.length ; i++) {
            if(i==order[result]) {
                result++;
            } else {
                belt.push(i);
            }
            while(!belt.isEmpty() && belt.peek()==order[result]) {
                belt.pop();
                result++;
            }
        }
        return result;
    }
}