import java.util.*;
class Solution {
    public int[] solution(String s) {
        String[] arr = s.split(",");
        Map<Integer,Integer> num = new HashMap<>();
        for(String ss : arr){
            Integer sss = Integer.valueOf(ss.replaceAll("[{]","").replaceAll("[}]", ""));
            num.put(sss,num.getOrDefault(sss,0)+1);
        }
        List<Integer> numList = new ArrayList<>(num.keySet());
        numList.sort((o1, o2) -> num.get(o2).compareTo(num.get(o1)));
        return numList.stream().mapToInt(i->i).toArray();
    }
}