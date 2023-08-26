class Solution {
    public int[] solution(int[] numlist, int n) {
        for (int j = 0; j < numlist.length; j++) {
			for (int i = 0; i < numlist.length - 1; i++) {
				int a = numlist[i] - n;
				if (a < 0) {
					a *= -1;
				}
				int b = numlist[i + 1] - n;
				if (b < 0) {
					b *= -1;
				}
				if (a > b) {
					int temp = numlist[i];
					numlist[i] = numlist[i + 1];
					numlist[i + 1] = temp;
				} else if (a == b && numlist[i] < numlist[i + 1]) {
					int temp = numlist[i];
					numlist[i] = numlist[i + 1];
					numlist[i + 1] = temp;
				}
			}
		}
		return numlist;
	}
}