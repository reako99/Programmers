class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        for(int i = 0 ; i < s.length(); i++) {
        	char tmp = s.charAt(i);
        	for(int j = 0 ; j < index; j++) {
        		tmp++;
        		if(tmp>'z') {
        			tmp-=26;
        		}
        		while(skip.indexOf(tmp)!=-1) {
        			tmp++;
        			tmp = (char)((tmp - 'a') % 26 + 'a');
        		}
        	}
        	answer+=tmp;
        }
        return answer;
    }
}