class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length]; // 정답을 저장할 배열 선언
		for (int i = 0; i < quiz.length; i++) {
			String[] spStr = quiz[i].split(" "); // 퀴즈의 문자열을 공백으로 잘라 새로운 문자열 배열에 넣고
			int[] spInt = new int[spStr.length]; // 해당 문자열에 해당하는 숫자를 int 타입으로 저장할 배열 선언
			for (int k = 0; k < spStr.length; k++) {
				if (k % 2 == 0) { // 0, 2, 4 번째에 오는 숫자 인덱스 값을 구분하여 
					if (spStr[k].contains("-")) { // 음수인지 확인 후 
						spInt[k] = -1 * Integer.parseInt(spStr[k].substring(1)); // 음수이면 -1을 곱하여 저장
					} else {
						spInt[k] = Integer.parseInt(spStr[k]); // 양수이면 int 로만 바꾸어 저장
					}
				}
			}
			if (spStr[1].equals("-")) { // 연산자를 구분하여 계산식의 정답 여부를 확인하여 정답을 처음에 선언한
				if (spInt[0] - spInt[2] == spInt[4]) { // answer[]에 저장
					answer[i] = "O";
				} else {
					answer[i] = "X";
				}
			} else {
				if (spInt[0] + spInt[2] == spInt[4]) {
					answer[i] = "O";
				} else {
					answer[i] = "X";
				}
			}
		}
		return answer;
	}
}