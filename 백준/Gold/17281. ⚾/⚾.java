import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] innings;
    static boolean[] used = new boolean[9];
    static int[] order = new int[9];
    static int maxScore = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        innings = new int[N][9];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                innings[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 1번 선수(인덱스0)를 4번 타순(인덱스3)에 고정
        used[0] = true;
        order[3] = 0;
        dfs(0);
        System.out.println(maxScore);
    }

    // idx: 타순 인덱스(0~8)
    static void dfs(int idx) {
        if (idx == 9) {
            simulate();
            return;
        }
        if (idx == 3) {  // 4번 타자 자리 건너뛰기
            dfs(idx + 1);
            return;
        }
        for (int i = 1; i < 9; i++) {
            if (!used[i]) {
                used[i] = true;
                order[idx] = i;
                dfs(idx + 1);
                used[i] = false;
            }
        }
    }

    static void simulate() {
        int score = 0, batter = 0;
        for (int inning = 0; inning < N; inning++) {
            int outs = 0, bases = 0;
            while (outs < 3) {
                int hit = innings[inning][order[batter]];
                switch (hit) {
                    case 0: // 아웃
                        outs++;
                        break;
                    case 1: // 1루타
                        score += (bases >> 2);
                        bases = ((bases << 1) | 1) & 0b111;
                        break;
                    case 2: // 2루타
                        score += (bases >> 1) & 1;
                        score += (bases >> 2) & 1;
                        bases = ((bases << 2) | 2) & 0b111;
                        break;
                    case 3: // 3루타
                    	score += Integer.bitCount(bases);
                        bases = 0b100;
                        break;
                    case 4: // 홈런
                    	score += Integer.bitCount(bases) + 1;
                        bases = 0;
                        break;
                }
                batter = (batter + 1) % 9;
            }
        }
        if (score > maxScore) maxScore = score;
    }
}

