import java.io.*;
import java.util.*;

public class Main {
    public static void jose(ArrayList<Integer> list, int k, int index, ArrayList<Integer> result) {
        if (list.isEmpty()) return; 

        index = (index + k - 1) % list.size();
        result.add(list.remove(index));

        jose(list, k, index, result);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        ArrayList<Integer> result = new ArrayList<>();
        jose(list, K, 0, result);

        bw.write("<");
        for (int i = 0; i < result.size() - 1; i++) {
            bw.write(result.get(i) + ", ");
        }
        bw.write(result.get(result.size() - 1) + ">\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
