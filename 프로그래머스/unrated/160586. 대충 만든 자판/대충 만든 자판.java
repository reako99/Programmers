class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        for(int i = 0 ; i < targets.length; i++) {
        	for(int j = 0 ; j < targets[i].length(); j++) {
        		int minIndex = 101;
        		boolean isPossible = true;
        		for(int k = 0 ; k < keymap.length; k++) {
        			int n = keymap[k].indexOf(targets[i].charAt(j));
        			if(n<0){
        				n=101;
        			}
        			minIndex=Math.min(minIndex, n);
        		}
        		if(minIndex==101) {
        			isPossible=false;
        		}
        		answer[i]+=minIndex+1;
        		if(!isPossible) {
        			answer[i]=-1;
        			break;
        		}
        	}
        }
        return answer;
    }
}