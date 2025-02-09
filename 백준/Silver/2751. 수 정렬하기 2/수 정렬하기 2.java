import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] count = new int[n];
		
		for (int i = 0; i < n; i++) {
			count[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(count);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
				sb.append(count[i]).append("\n");
		}
		System.out.println(sb.toString());

	}

}