import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        int N = A.length;
        
        //A,B 오름차순 정렬
        Arrays.sort(A);
        Arrays.sort(B);
        
        for (int i = 0; i < N; i++) {
            answer += A[i] * B[N-i-1];
        }

        return answer;
    }
}