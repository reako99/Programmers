import java.util.*;
class Solution {
    boolean[] visited;
    int count=0;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0,k,dungeons);
        return count;
    }

    public void dfs(int depth, int fatigue, int[][] dungeons){
        for(int i = 0 ; i < dungeons.length; i++){
            if(visited[i]||dungeons[i][0]>fatigue){
                continue;
            }
            visited[i]=true;
            dfs(depth+1, fatigue - dungeons[i][1], dungeons);
            if(count == dungeons.length){
                return;
            }
            visited[i]=false;
        }
        count = Math.max(count, depth);
    }
}