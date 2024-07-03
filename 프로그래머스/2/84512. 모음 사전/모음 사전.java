import java.util.HashMap;
import java.util.Map;
class Solution {
    static int cnt= 1;
    public int solution(String word) {
        Map<String, Integer> map  = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        init(0,"",map);
        for(int i = 0 ; i < word.length() ; i++){
            char curChar = word.charAt(i);
            switch(curChar){
                case 'A' :
                    sb.append(0);
                    break;
                case 'E' :
                    sb.append(1);
                    break;
                case 'I' :
                    sb.append(2);
                    break;
                case 'O' :
                    sb.append(3);
                    break;
                case 'U' :
                    sb.append(4);
                    break;
            }
        }
        String key = sb.toString();
        return map.get(key);
    }
    public void init(int depth, String currentStr, Map<String,Integer> map){
        if(depth==5){
            return;
        }
        for(int i = 0 ; i < 5; i++){
            String next = currentStr + Integer.toString(i);
            map.put(next,cnt);
            cnt++;
            init(depth+1,next,map);
        }
    }
}