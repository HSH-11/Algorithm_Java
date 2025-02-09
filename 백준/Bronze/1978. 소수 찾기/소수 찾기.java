import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String input = br.readLine(); 
		String[] nums = input.split(" ");
		int cnt = 0;
		for (String c: nums) {
			int n = Integer.valueOf(c);
			boolean num = false;
			for (int i = 2; i < n; i++) {
				if (n % i == 0) {
					num = true;
					break;
				}
			}
			if (!num && n != 1) {cnt++;}
		}
		System.out.println(cnt);
		
	}

}