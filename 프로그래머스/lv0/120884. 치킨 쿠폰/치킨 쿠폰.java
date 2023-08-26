class Solution {
    public int solution(int chicken) {
       int coupon = chicken;
		int service = (coupon / 10);
		coupon %= 10;
		int answer = service;
		while ((coupon + service) >= 10) {
			int cou1 = coupon + service;
			service = cou1 / 10;
			coupon = cou1 % 10 ;
			answer += service;
		}
		return answer;
	}
}