import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> ans = new ArrayList<>();
        String Enter = " 들어왔습니다.";
        String Leave = " 나갔습니다.";
        Map<String, String> idToNickname = new HashMap<>();
        for(String recordStr : record) {
            String[] splitStr = recordStr.split(" ");
            if(splitStr[0].equals("Leave")){
                continue;
            }
            idToNickname.put(splitStr[1], splitStr[2]);
        };

        for(String recordStr : record) {
            String[] splitStr = recordStr.split(" ");
            StringBuilder sb = new StringBuilder();
            if(splitStr[0].equals("Enter")) {
                sb.append(idToNickname.get(splitStr[1])).append("님이").append(Enter);
            }else if(splitStr[0].equals("Change")){
                continue;
            }else{
                sb.append(idToNickname.get(splitStr[1])).append("님이").append(Leave);
            }
            ans.add(sb.toString());
        };
        String[] answer = new String[ans.size()];
        for(int i = 0 ; i < ans.size(); i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}