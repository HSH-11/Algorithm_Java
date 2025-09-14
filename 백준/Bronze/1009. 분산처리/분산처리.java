import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) % 10;
            int b = Integer.parseInt(st.nextToken());

            
            if (a == 0) {
                System.out.println(10);
                continue;
            }

            int result = 1;
            // 주기의 길이는 최대 4이므로 b % 4 + 4를 해서 항상 양의 수로 만듦
            for (int i = 0; i < (b % 4 == 0 ? 4 : b % 4); i++) {
                result = (result * a) % 10;
            }

            System.out.println(result);
        }
	}
}