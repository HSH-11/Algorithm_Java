import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    static int N, M;  
    static int[] src;  
    static int[] tgt;  
    static boolean[] select;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        src = new int[N];
        tgt = new int[M];
        select = new boolean[N];

        for (int i = 0; i < N; i++) {
            src[i] = i + 1;
        }

        perm(0, bw);
        
        bw.flush();
        bw.close();
    }

    static void perm(int tgtIdx, BufferedWriter bw) throws IOException {
        if (tgtIdx == M) {
            for (int i = 0; i < M; i++) {
                bw.write(tgt[i] + "\n");
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (select[i]) continue;  

            tgt[tgtIdx] = src[i];  
            select[i] = true;  

            perm(tgtIdx + 1, bw);  

            select[i] = false;  
        }
    }
}