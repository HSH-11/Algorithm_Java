class Solution {
    
    //빈칸에 숫자 채우기
    //#1. direction
    //#2. r,c이용
    public static int solution(int n, int w, int num) {
	        // num이 위치한 열의 위치를 구하기
	        int targetCol = getCol(num,w);
            int answer = 0;
            
            //목표 상자부터 마지막 상자까지 순회하면서
            //같은 열에 있는 상자의 개수 카운트
            for (int i = num; i <= n; i++){
                if(getCol(i,w) == targetCol) answer++;
            }
            return answer;
	    }
    
    static int getCol(int num, int w){
        //상자가 몇 번째 행에 있는지 계산
        int row = (num -1) / w;
        int pos = (num - 1) % w;
        
        //짝수 행: 왼쪽 -> 오른쪽 순서로 배치
        //홀수 행: 오른쪽 -> 왼쪽 순서로 배치
        return row % 2 == 0 ? pos : (w - 1 - pos);
    }
}