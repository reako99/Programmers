import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        Queue<String> cacheQue = new LinkedList<>();
        int answer = 0;
        for(int i = 0 ; i < cities.length ; i++){
            String city = cities[i].toLowerCase();
            if(!cacheQue.contains(city)){
                cacheQue.add(city);
                answer+=5;
            }else{
                Queue<String>tempQue = new LinkedList<>();
                for(String s : cacheQue){
                    if(city.equals(s)){
                        continue;
                    }
                    tempQue.add(s);
                }
                cacheQue=tempQue;
                cacheQue.add(city);
                answer++;
            }
            if(cacheQue.size()>cacheSize){
                cacheQue.poll();
            }
        }
        return answer;
    }
}