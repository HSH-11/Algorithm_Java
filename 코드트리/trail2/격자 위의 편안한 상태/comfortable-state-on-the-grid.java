import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    
    static final int DIR_NUM = 4;
    static final int MAX_N = 100;

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    static int[][] arr;
    static int n, m;

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        StringBuilder out = new StringBuilder();
        
        in.nextToken(); n = (int) in.nval;
        in.nextToken(); m = (int) in.nval;
        
        arr = new int[n + 1][n + 1];
        
        for (int i = 0; i < m; i++) {
            in.nextToken(); int x = (int) in.nval;
            in.nextToken(); int y = (int) in.nval;

            x--;
            y--;

            arr[x][y] = 1;
            
            int cnt = 0;
            for (int d = 0; d < DIR_NUM; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (inRange(nx, ny) && arr[nx][ny] == 1)
                    cnt++;
            }

            if (cnt == 3) 
                out.append(1).append('\n');
            else 
                out.append(0).append('\n');
        
        }

        System.out.print(out);

    }

    public static boolean inRange (int x, int y) {
        return (0 <= x && x < n && 0 <= y && y < n);
    }
}