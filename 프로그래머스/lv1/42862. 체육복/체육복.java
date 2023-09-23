import java.util.Stack;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int[]student=new int[n];
        for(int i = 0 ; i < n ; i++) {
        	student[i]=0;
        }
        for(int i = 0 ; i < lost.length; i++) {
        	student[lost[i]-1]--;
        }
        for(int i = 0 ; i < reserve.length; i++) {
        	student[reserve[i]-1]++;
        }
        Stack<Integer> impossible = new Stack<>();
        for(int i = 0 ; i < n; i ++) {
        	if(student[i]==0) {
        		impossible.push(0);
        	}else if(impossible.size()==0) {
        		impossible.push(student[i]);
        	}else if(student[i]==1) {
        		if(impossible.peek()==-1) {
        			impossible.pop();
        			impossible.push(0);
        		}else {
        			impossible.push(1);
        		}
        	}else {
        		if(impossible.peek()==1) {
        			impossible.pop();
        			impossible.push(0);
        		}else {
        			impossible.push(-1);
        		}
        	}
        }
        int size = impossible.size();
        for(int i = 0 ; i < size; i++) {
        	if(impossible.pop()==-1) {
        		answer--;
        	}
        }
        return answer;
    }
}