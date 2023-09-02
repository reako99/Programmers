class Solution {
    public String solution(String s) {
      String answer = "";
		int k = 0;
		int n = s.length();
		for(int i = 0 ; i< n ; i++) {
			if(s.charAt(i)!=' ') {
				if(k%2==0) {
					answer+=s.toUpperCase().charAt(i);
					k++;
				}else {
					answer+=s.toLowerCase().charAt(i);
					k++;
				}
			}else {
				k=0;
				answer+=s.charAt(i);
			}
		}
        return answer;
    }
}