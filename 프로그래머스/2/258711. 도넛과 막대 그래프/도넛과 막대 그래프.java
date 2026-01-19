import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] outCount = new int[1000001];
        int[] inCount = new int[1000001];
        boolean[] isExist = new boolean[1000001]; 
        
        int maxNode = 0;
        for (int[] edge : edges) {
            outCount[edge[0]]++;
            inCount[edge[1]]++;
            isExist[edge[0]] = true;
            isExist[edge[1]] = true;
            maxNode = Math.max(maxNode, Math.max(edge[0], edge[1]));
        }
        
        int createNode = -1;
        int bar = 0;
        int eight = 0;
        
        for (int i = 1; i <= maxNode; i++) {
            if (!isExist[i]) continue;
            
            // 생성된 정점 : 나가는 것 2개 이상, 들어오는 것 0개
            if (outCount[i] >= 2 && inCount[i] == 0) {
                createNode = i;
            }
            // 막대 그래프 : 나가는 게 0개
            else if (outCount[i] == 0) {
                bar++;
            }
            // 8자 그래프 : 나가는 게 2개 (생성된 정점과 겹치지 않게 inCount 확인)
            else if (outCount[i] == 2 && inCount[i] >= 2) {
                eight++;
            }
        }
        
        // 도넛 계산
        int donut = outCount[createNode] - bar - eight;
        
        return new int[] {createNode, donut, bar, eight};
    }
}