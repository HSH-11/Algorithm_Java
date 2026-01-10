import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int cnt = 0;  // 확실히 맞은 번호 개수
        int zero = 0; // 지워진 번호(0)의 개수

        // 맞은 개수와 0의 개수 파악
        for (int num : lottos) {
            if (num == 0) {
                zero++;
                continue;
            }
            for (int win : win_nums) {
                if (num == win) {
                    cnt++;
                    break;
                }
            }
        }

        // 최고 순위와 최저 순위 계산
        // 최고: 다 맞았을 때 (현재 맞은 개수 + 0의 개수)
        // 최저: 다 틀렸을 때 (현재 맞은 개수)
        return new int[]{getRank(cnt + zero), getRank(cnt)};
    }

    // 맞은 개수에 따른 순위 반환 메서드
    public int getRank(int n) {
        switch (n) {
            case 6: return 1;
            case 5: return 2;
            case 4: return 3;
            case 3: return 4;
            case 2: return 5;
            default: return 6;
        }
    }
}