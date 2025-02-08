import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - i - 1; j++) {
				sb.append(" ");
			}
			for (int j = N; j > N - i - 1; j--) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}
}