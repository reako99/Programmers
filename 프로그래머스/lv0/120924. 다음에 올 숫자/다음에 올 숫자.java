class Solution {
    public int solution(int[] common) {
        int a = common[2]-common[1];
		int b = common[1]-common[0];
        if(b==0){
            return common[common.length-1];
        }
		int c = a/ b;
        return common[common.length-1]+(common[common.length-1]-common[common.length-2])*c;
    }
}