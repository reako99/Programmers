import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> cluster1 = new HashMap<>();
        Map<String, Integer> cluster2 = new HashMap<>();
        for (int i = 0 ; i < str1.length()-1; i++){
            String key = str1.substring(i, i+2);
            if(isEngChar(key)){
                key = key.toLowerCase();
                cluster1.put(key,cluster1.getOrDefault(key,0)+1);
            }
        }
        for (int i = 0 ; i < str2.length()-1; i++){
            String key = str2.substring(i, i+2);
            if(isEngChar(key)){
                key = key.toLowerCase();
                cluster2.put(key,cluster2.getOrDefault(key,0)+1);
            }
        }
        int us = 0;
        int union = 0;
        Set<String> keys = new HashSet<>();
        keys.addAll(cluster1.keySet());
        keys.addAll(cluster2.keySet());
        Iterator<String> iter = keys.iterator();
        while(iter.hasNext()){
            String key = iter.next();
            us+=Math.min(cluster1.getOrDefault(key,0), cluster2.getOrDefault(key, 0));
            union+=Math.max(cluster1.getOrDefault(key,0), cluster2.getOrDefault(key, 0));
        }
        if(union==0&&us==0){
            return 65536;
        }
        if(union==0){
            return 0;
        }
        int answer = us*65536/union;
        return answer;
    }

    public boolean isEngChar(String s){
        if(s.charAt(0)<='z'&&s.charAt(0)>='a'||s.charAt(0)<='Z'&&s.charAt(0)>='A'){
            if(s.charAt(1)<='z'&&s.charAt(1)>='a'||s.charAt(1)<='Z'&&s.charAt(1)>='A'){
                return true;
            }
        }
        return false;
    }
}