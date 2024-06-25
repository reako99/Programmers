class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < t*m; i ++){
            String st = st(n,i);
            sb.append(st);
        }
        String str = sb.toString();
        StringBuilder nsb = new StringBuilder();
        for(int i = 0 ; i < t ;  i ++){
            nsb.append(str.charAt(p+i*m-1));
        }
        return nsb.toString();
    }

    private String st(int n, int i) {
        if(i==0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while(i>0){
            if(n>10){
                if(i%n>9){
                    int in = 'A' + (i%n-10);
                    char ch = (char) in;
                    sb.append(ch);
                }else{
                    sb.append(String.valueOf(i%n));
                }
                i/=n;
            }else {
                sb.append(String.valueOf(i % n));
                i /= n;
            }
        }
        return sb.reverse().toString();
    }
}