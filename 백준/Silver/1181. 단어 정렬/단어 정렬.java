import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());		
		Set<String> set = new HashSet<>();
		StringBuilder sb= new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		List<String> list = new ArrayList<>(set);
		Collections.sort(list,(s1,s2)->{
			if (s1.length() == s2.length()) {
				return s1.compareTo(s2);
			}else {
				return s1.length()-s2.length();
			}
		});
		
		for (String word: list) {
			sb.append(word).append("\n");
		}
		System.out.println(sb);
	}

}