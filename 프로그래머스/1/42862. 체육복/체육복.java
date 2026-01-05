import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 정렬을 먼저 해야 앞번호부터 꼬이지 않고 빌려줄 수 있음.
        Arrays.sort(lost);
        Arrays.sort(reserve);

        int least = n - lost.length;
        boolean[] isReserve = new boolean[n + 2]; // n+1 index 접근 시 에러 방지를 위해 +2
        
        for (int number : reserve) {
            isReserve[number] = true;
        }

        // 본인이 도난당한 경우를 "먼저" 모두 처리.
        List<Integer> stillLost = new ArrayList<>();
        for (int l : lost) {
            if (isReserve[l]) {
                least++;
                isReserve[l] = false;
            } else {
                stillLost.add(l);
            }
        }

        // 실제로 남에게 빌림
        for (int l : stillLost) {
            if (isReserve[l - 1]) {
                least++;
                isReserve[l - 1] = false;
            } else if (isReserve[l + 1]) {
                least++;
                isReserve[l + 1] = false;
            }
        }

        return least;
    }
}