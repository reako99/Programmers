import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        Map<Integer, Set<Integer>> group = new HashMap<>();
        for(int i = 0 ; i < n ; i ++){
            Set<Integer> groupSet = group.getOrDefault(i, new HashSet<>());
            for(int j = 0 ; j < n ; j ++){
                if(computers[i][j]==1){
                    if(group.get(j)==null){
                        groupSet.add(j);
                    }else{
                        groupSet.addAll(group.get(j));
                    }
                    for(Integer com : groupSet){
                        group.put(com,groupSet);
                    }
                }
            }
            group.put(i,groupSet);

        }
        Set<Set<Integer>> groupAddress = new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            groupAddress.add(group.get(i));
        }
        return groupAddress.size();
    }
}