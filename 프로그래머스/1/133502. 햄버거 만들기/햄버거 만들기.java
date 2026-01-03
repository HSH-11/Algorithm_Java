class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        int[] stack = new int[ingredient.length];
        int top = 0; // 다음에 들어올 원소의 위치

        for (int ing : ingredient) {
            stack[top++] = ing; // push

            // 4개 이상 쌓였을 때 검사
            if (top >= 4) {
                if (stack[top - 4] == 1 &&
                    stack[top - 3] == 2 &&
                    stack[top - 2] == 3 &&
                    stack[top - 1] == 1) {
                    
                    answer++;
                    top -= 4; // 4개 꺼내기
                }
            }
        }
        return answer;
    }
}