import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < N; i++) {		
			set.add(Integer.parseInt(st.nextToken()));
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int m = 0; m < M; m++) {
			if (set.contains(Integer.parseInt(st.nextToken()))) {
				sb.append("1\n");}
			else {
				sb.append("0\n");}
		}
		System.out.println(sb.toString());

	}

}