import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		Set<String> heard = new HashSet<>();
		for (int i = 0; i < N; i++) {
			String name = br.readLine();
			heard.add(name);
		}
		Set<String> seen = new HashSet<>();
		for (int j = 0; j < M; j++) {
			String name = br.readLine();
			seen.add(name);
		}
		
		heard.retainAll(seen);
		
		List<String> result = new ArrayList<>(heard);
		Collections.sort(result);
		
		sb.append(result.size()).append("\n");
		for (String name: result) {
			sb.append(name).append("\n");
		}
		System.out.println(sb.toString());

	}
}