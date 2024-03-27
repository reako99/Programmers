import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] numbers, int target) {
        Queue<Integer> list = new LinkedList<>();
        Queue<Integer> result = new LinkedList<>();
        for(int number:numbers){
            list.add(number);
        }
        while(!list.isEmpty()){
            int num = list.poll();
            if (result.isEmpty()){
                result.add(num);
                result.add(-1*num);
            }
            else {
                int size = result.size();
                for(int i = 0; i < size; i++){
                    int x = result.poll();
                    result.add(x+num);
                    result.add(x-num);
                }
            }
        }
        int answer = 0;
        while(!result.isEmpty()){
            if(result.poll()==target){
                answer++;
            }
        }
        return answer;
    }
}