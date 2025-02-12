import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int x = 0; x < N; x++) {  
            for (int y = 0; y < N; y++) {
                if (Blank(y, x)) {
                    bw.write(" ");
                } else {
                    bw.write("*");
                }
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    static boolean Blank(int y, int x) {
        while (x > 0 || y > 0) {
            if (y % 3 == 1 && x % 3 == 1) return true;
            x /= 3;
            y /= 3;
        }
        return false;
    }
}