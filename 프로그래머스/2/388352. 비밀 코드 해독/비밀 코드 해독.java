class Solution {
    static int solution(int n, int[][] q, int[] ans) {
				
		int count = 0;
		for (int mask = 0; mask < (1 << n); mask++) {
			if (Integer.bitCount(mask) != 5) continue;
			if (isValid(mask,q,ans)) count++;
		}
         return count;
	}
	
	//매칭된 결과가 정답과 같으면 일단 통과
	//끝까지 통과하면 true로 비밀코드 후보에 해당
	static boolean isValid(int mask, int[][]q,int[] ans) {
		for (int i = 0; i < q.length; i++) {
			if (matching(mask,q[i]) != ans[i]) return false;
		}
		return true;
	}
	//생성된 마스크와 q의 숫자를 비교해서 같은 개수 파악
	static int matching(int mask, int[] query) {
		int match = 0;
		for (int num : query) {
			if ((mask & (1 << (num - 1))) != 0) {
				match++;
			}
		}
		return match;
	}
}