import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] A, int[] B) {
        int count = 0;
        int[] sortedA = Arrays.stream(A).sorted().toArray();
        List<Integer> sortedB = Arrays.stream(B).sorted().boxed().collect(Collectors.toList());
        for(int i = A.length-1; i>=0 ; i--){
            if(sortedA[i]<sortedB.get(sortedB.size()-1)){
                count++;
                sortedB.remove(sortedB.size()-1);
            }else{
                sortedB.remove(0);
            }
        }

        return count;
    }
}