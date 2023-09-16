class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for(int i = 0 ; i < babbling.length; i++) {
        	babbling[i]=babbling[i].replaceAll("aya", "1");
        	babbling[i]=babbling[i].replaceAll("ye", "2");
        	babbling[i]=babbling[i].replaceAll("woo", "3");
        	babbling[i]=babbling[i].replaceAll("ma", "4");
        	for(int j = 0 ; j < babbling[i].length(); j++) {
        		if(babbling[i].length()==1) {
        			if(babbling[i].charAt(0)>='1'&&babbling[i].charAt(0)<='4') {
        				answer++;
        				break;
        			}
        		}
        		if(babbling[i].charAt(j)>='1'&&babbling[i].charAt(j)<='4') {
        			if(babbling[i].charAt(babbling[i].length()-1)>='1'&&
        					babbling[i].charAt(babbling[i].length()-1)<='4') {
        				if(babbling[i].charAt(j)==babbling[i].charAt(j+1)) {
        					break;
        				}
        				if(j==babbling[i].length()-2) {
        					answer++;
        					break;
        				}
        			}else {
        				break;
        			}
        		}else {
        			break;
        		}
        	}
        }
        return answer;
    }
}