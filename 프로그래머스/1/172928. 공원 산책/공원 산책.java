class Solution {
    public int[] solution(String[] park, String[] routes) {
        int w = park[0].length();
        int h = park.length;
        
        int r = 0;
        int c = 0;
        
        // 시작 지점 찾기
        for (int i = 0; i < h; i++) {
            if (park[i].contains("S")) {
                r = i;
                c = park[i].indexOf("S");
                break;
            }
        }
        
        // 명령 수행
        for (String route : routes) {
            String[] split = route.split(" ");
            String dir = split[0];
            int dist = Integer.parseInt(split[1]);
            
            int curR = r;
            int curC = c;
            boolean isPossible = true;
            
            for (int i = 0; i < dist; i++) {
                if (dir.equals("E")) curC++;
                else if (dir.equals("W")) curC--;
                else if (dir.equals("S")) curR++;
                else if (dir.equals("N")) curR--;
                
                // 범위 벗어나거나 장애물 만남
                if (curR < 0 || curR >= h || curC < 0 || curC >=w || park[curR].charAt(curC) == 'X') {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                r = curR;
                c = curC;
            }
        }
        
        return new int[] {r, c};
    }
}