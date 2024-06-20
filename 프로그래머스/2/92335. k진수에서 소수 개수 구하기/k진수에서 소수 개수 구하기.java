class Solution {
    public int solution(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while(n>0){
            sb.append(n%k);
            n/=k;
        }
        sb.reverse();
        String[] strArr = sb.toString().split("0");
        int answer = 0;
        for(int i = 0 ; i < strArr.length; i++){
            if(strArr[i].isEmpty()){
                continue;
            }
            if(isPrime(Long.parseLong(strArr[i]))){
                answer++;
            }
        }
        return answer;
    }


    public boolean isPrime(long num){
        if(num==1){
            return false;
        }
        for(int i = 2 ; i<=(int)Math.sqrt(num); i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}