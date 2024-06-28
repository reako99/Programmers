import java.util.*;
class Solution {
    public int[] solution(String msg) {
        List<Integer> ansList = new ArrayList<>();
        Map<String, Integer> dict = new HashMap<>();
        for(int i = 1 ; i < 27; i++){
            dict.put(String.valueOf((char)('A'+i-1)),i);
        }
        for(int i = 0 ; i < msg.length(); i++){
            for(int j = i+1 ; j <= msg.length(); j++){
                if(dict.getOrDefault(msg.substring(i, j),0)==0){
                    dict.put(msg.substring(i, j),dict.size()+1);
                    ansList.add(dict.get(msg.substring(i, j-1)));
                    i=j-2;
                    break;
                }else if(j==msg.length()){
                    ansList.add(dict.get(msg.substring(i, j)));
                    int[] answer = new int[ansList.size()];
                    for(int k = 0 ; k < answer.length; k++){
                        answer[k]=ansList.get(k);
                    }
                    return answer;
                }
            }
        }
        int[] answer = new int[ansList.size()];
        for(int i = 0 ; i < answer.length; i++){
            answer[i]=ansList.get(i);
        }
        return answer;
    }
}