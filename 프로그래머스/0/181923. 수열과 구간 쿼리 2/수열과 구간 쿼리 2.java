class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        int idx = 0;
        for (int[] query : queries) {
            int s = query[0];
            int e = query[1];
            int k = query[2];
            int min = 1000001;
            for (int i = s; i <= e; i++) {
                if (arr[i] > k && arr[i] < min) min = arr[i];
            }
            
            answer[idx] = (min == 1000001) ? -1 : min;
            idx++;
        }
        return answer;
    }
}