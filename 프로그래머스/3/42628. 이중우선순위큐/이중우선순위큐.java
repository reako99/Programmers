import java.util.Set;
import java.util.HashSet;
class Solution {
    public int[] solution(String[] operations) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < operations.length; i++){
            String[] operation = operations[i].split(" ");
            switch (operation[0].charAt(0)){
                case 'I': set.add(Integer.parseInt(operation[1]));
                break;
                default:
                    if(operation[1].charAt(0)=='-') {
                        set.remove(findMin(set));
                    }else{
                        set.remove(findMax(set));
                    }
                    break;
            }
        }

        int[] answer = new int [2];
        int[] emptyArr = {0,0};
        if(set.isEmpty()){
            return emptyArr;
        }
        answer[0]=findMax(set);
        answer[1]=findMin(set);

        return answer;
    }

    private int findMax(Set<Integer> set) {
        int max = Integer.MIN_VALUE;
        for(Integer i : set){
            if(max<i){
                max=i;
            }
        }
        return max;
    }

    private int findMin(Set<Integer> set) {
        int min = Integer.MAX_VALUE;
        for(Integer i : set){
            if(min>i){
                min=i;
            }
        }
        return min;
    }
}