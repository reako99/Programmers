class Solution {
    public void danger(int i, int j, int[][] reboard){
        for(int k=i-1; k<=i+1; k++){
            for(int l=j-1; l<=j+1; l++){
                if(reboard[k][l]==0){
                    reboard[k][l]=2;
                }
            }
        }
    }
    public int solution(int[][] board) {
        int n = board.length;
        int[][] reboard = new int [n+2][n+2];
        for (int i=0; i<n; i++){
            for(int j =0 ; j< n ; j++){
                reboard[i+1][j+1]=board[i][j];
            }
        }
        int answer = 0;
        
        for(int i= 1; i< n+1; i++){
            for(int j=1; j< n+1 ; j++){
                if(reboard[i][j]==1){
                    danger(i,j,reboard);
                }
            }
        } 
        for(int i=1; i< n+1; i++){
            for(int j=1; j<n+1; j++){
                if(reboard[i][j]==0){
                    answer++;
                }
            }
        }
        return answer;
    }
}