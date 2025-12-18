class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int lastPainted = 0;
        
        for (int s : section) {
            // 현재 확인하는 구역이 이미 칠해진 범위 밖에 있다면
            if (s > lastPainted) {
                answer++;
                lastPainted = s + m - 1;
            }
        }
        
        return answer;
    }
}