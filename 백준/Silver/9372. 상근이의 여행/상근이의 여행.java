import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine()); 

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 국가의 수
			int M = Integer.parseInt(st.nextToken()); // 비행기의 수
			
			for (int i = 0; i < M; i++) {
                br.readLine();
            }
			
			sb.append(N - 1).append("\n");
			
		}
		System.out.print(sb);
		
	}

}