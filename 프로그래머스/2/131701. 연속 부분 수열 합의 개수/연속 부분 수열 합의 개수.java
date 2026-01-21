import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int n = elements.length;

        // 인덱스 0부터 n-1까지 순회
        for (int i = 0; i < n; i++) {
            int sum = 0;
            // 부분 수열의 길이(len)를 1부터 n까지 늘려가며 합산
            for (int len = 1; len <= n; len++) {
                // (i + len - 1) % n 은 현재 길이에 해당하는 마지막 원소의 위치
                sum += elements[(i + len - 1) % n];
                set.add(sum);
            }
        }

        return set.size();
    }
}