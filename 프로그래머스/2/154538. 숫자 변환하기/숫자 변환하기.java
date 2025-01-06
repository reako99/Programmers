import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
         Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,0});
        boolean[] visited = new boolean[1000000*3];

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            if(now[0]==y){
                return now[1];
            }
            int[] ints = {now[0]+n, now[0]*2, now[0]*3};
            int count = now[1]+1;
            for(int i : ints) {
                if(!visited[i] && i<=y) {
                    queue.offer(new int[]{i,count});
                    visited[i] = true;
                }
            }
        }
        return -1;
    }
}