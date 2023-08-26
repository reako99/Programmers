class Solution {
    public String solution(String polynomial) {
        String answer = "";
		String[] splitPoly = polynomial.split(" ");
		int a = 0;
		int b = 0; // ax + b 의 꼴로 하기 위함
		for (int i = 0; i < splitPoly.length; i++) {
			if (i % 2 == 0 && splitPoly[i].contains("x")) {
				if (splitPoly[i].length() == 1) {
					a++;
				} else {
					a += Integer.parseInt(splitPoly[i].substring(0, splitPoly[i].length() - 1));
				}
			} else if (i % 2 == 0) {
				b += Integer.parseInt(splitPoly[i]);
			}
		}
		if (a != 0) {
			if (a == 1) {
				answer += "x";
			} else {
				answer = answer + a + "x";
			}
		}
		if (a != 0 && b != 0) {
			answer += " + ";
		}
		if (b != 0) {
			answer = answer + b;
		}
		return answer;
	}
}