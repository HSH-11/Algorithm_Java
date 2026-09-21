import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        HashSet<String> hashSet = new HashSet<>();
        ArrayDeque<String> dq = new ArrayDeque<>();

        for (String city : cities) {
            city = city.toUpperCase();

            // Cache Hit
            if (hashSet.contains(city)) {
                answer += 1;

                // 최근 사용한 도시로 이동
                dq.remove(city);
            }
            // Cache Miss
            else {
                answer += 5;

                if (dq.size() == cacheSize) {
                    String last = dq.removeLast();
                    hashSet.remove(last);
                }
            }

            dq.addFirst(city);
            hashSet.add(city);
        }

        return answer;
    }
}