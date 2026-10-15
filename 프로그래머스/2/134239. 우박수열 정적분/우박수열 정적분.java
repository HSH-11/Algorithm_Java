import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        
        List<Integer> sequence = new ArrayList<>();
        sequence.add(k);
        
        // 좌표 저장        
        while (k > 1) {
            if (k % 2 == 0) {
                k /= 2;
            } else {
                k = k * 3 + 1;
            }
            
            sequence.add(k);
        }
        
        // 구간별 면적 누적합
        double[] prefix = new double[sequence.size()];
        
        for (int i = 1; i < sequence.size(); i++) {
            double area = (sequence.get(i-1) + sequence.get(i)) / 2.0;
            prefix[i] = prefix[i-1] + area;
        }
        
        // 구간 처리
        double[] answer = new double[ranges.length];
        int n = sequence.size() - 1;
        for (int i = 0; i < ranges.length; i++) {
            int a = ranges[i][0];
            int b = ranges[i][1];
            
            int end = n + b;
            
            // 시작점이 끝점보다 뒤에 있는 경우
            if (a > end) {
                answer[i] = -1.0;
            } else {
                answer[i] = prefix[end] - prefix[a];
            }
        }
        
        return answer;
    }
}