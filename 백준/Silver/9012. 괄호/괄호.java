import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String input = br.readLine();
			boolean is_valid = true;
			int bracket = 0;
			
			for (char c: input.toCharArray()) {
				if (c == '(') {
					bracket++;
				}else if (c==')') {
					bracket--;
					if (bracket < 0) {
						is_valid = false;
						break;
					}
				}
			}
			if (bracket != 0) {
				is_valid = false;
			}
			if (is_valid) {System.out.println("YES");}
			else {System.out.println("NO");}
			
		}
		br.close();
		
		
	}
}