import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public int solution(int[][] maps) {
        int m = maps.length;
        int n = maps[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0,0});
        while(!queue.isEmpty()){
            int[] curXY = queue.poll();
            int x = curXY[1];
            int y = curXY[0];
            if(y==m-1&&x==n-1){
                return maps[y][x];
            }
            if(y+1<m&&maps[y+1][x]==1){
                maps[y+1][x]=maps[y][x]+1;
                queue.add(new int[] {y+1, x});
            }
            if(x+1<n&&maps[y][x+1]==1){
                maps[y][x+1]=maps[y][x]+1;
                queue.add(new int[] {y, x+1});
            }
            if(!(x==0&&y-1==0)&&y>0&&maps[y-1][x]==1){
                maps[y-1][x]=maps[y][x]+1;
                queue.add(new int[] {y-1, x});
            }
            
            if(!(x-1==0&&y==0)&&x>0&&maps[y][x-1]==1){
                maps[y][x-1]=maps[y][x]+1;
                queue.add(new int[] {y, x-1});
            }
        }
        if(maps[m-1][n-1]!=1){
            return maps[m-1][n-1];
        }
        return -1;

    }
}