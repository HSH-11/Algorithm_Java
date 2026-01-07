import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        // 빈 배열 처리
        if (arr.length <= 1) return new int[] {-1};

        // 최솟값 찾기
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        // 최솟값을 제외하고 새 배열에 담기
        int[] answer = new int[arr.length - 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == min) continue; // 최솟값은 건너뛰기
            answer[index++] = arr[i];
        }

        return answer;
    }
}