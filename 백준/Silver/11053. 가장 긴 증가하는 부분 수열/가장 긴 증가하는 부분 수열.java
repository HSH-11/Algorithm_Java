import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> lis = new ArrayList<>();
        lis.add(arr[0]);

        for (int i = 1; i < N; i++) {
            if (arr[i] > lis.get(lis.size() - 1)) {
                lis.add(arr[i]);  // 증가하는 경우 추가
            } else {
                int idx = Collections.binarySearch(lis, arr[i]);
                if (idx < 0) idx = -idx - 1;
                lis.set(idx, arr[i]);  // 적절한 위치에 갱신
            }
        }

        System.out.println(lis.size());
    }
}
