import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		while (true) {
			String input = br.readLine();
			if(input.equals("0")) break;
			
			boolean enable = true;	
			int n = input.length();
			for (int i = 0; i < (n+1)/2; i++) {
				if ( input.charAt(i) != input.charAt(n-i-1)) {
					enable = false;
					break;
					}
			}
			if(enable) {System.out.println("yes");}
			else {System.out.println("no");}
					
		}

	}
}