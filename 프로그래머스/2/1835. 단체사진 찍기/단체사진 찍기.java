class Solution {
    
    boolean[] visited;
    char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    int answer;
    
    public int solution(int n, String[] data) {
        answer = 0;
        visited = new boolean[8];
        char[] order = new char[8];
        
        dfs(0, data, order);
        
        return answer;
    }
    
    // depth : 현재까지 배치한 캐릭터 수
    // data : 사진 촬영 조건
    // order : 현재 순열을 저장하는 배열
    private void dfs (int depth, String[] data, char[] order) {
        
        if (depth == 8) {
            // 모든 사진 촬영 조건 검사
            if (check(order, data)) answer++;
            
            return;
        }
        
        for (int i = 0; i < friends.length; i++) {
            // 이미 배치한 캐릭터이면 건너뛰기
            if (visited[i]) continue;
            
            // 현재 자리에 캐릭터 배치
            order[depth] = friends[i];
            visited[i] = true;
            
            dfs(depth + 1, data, order);
            
            visited[i] = false;
            
        }        
  
    }
    
    private boolean check(char[] order, String[] data) {
        
        // 개선사항(참고)
        // 각 캐릭터의 위치를 저장할 배열
        int[] position = new int[128];
        
        // 문자 코드 값을 인덱스로 사용하여 위치 저장
        for (int i = 0; i < order.length; i++) {
            position[order[i]] = i; //order[i] = 'A'이라면 position[65] = 0;
        }
        
        for (String condition : data) {
            char[] c = condition.toCharArray();
            
            char person1 = c[0];
            char person2 = c[2];
            char op = c[3];
            int distance = c[4] - '0';
            
            // 두 캐릭터 위치 조회
            int pos1 = position[person1];
            int pos2 = position[person2];
            
            // 두 캐릭터 사이에 있는 사람 수
            int gap = Math.abs(pos1 - pos2) - 1;
            
            switch (op) {
                case '=':
                    if (gap != distance) return false;
                    break;
                    
                case '<': 
                    if (gap >= distance) return false;
                    break;
                    
                case '>':
                    if (gap <= distance) return false;
                    break;                              
            }
        } 
        
        return true;
    }
}