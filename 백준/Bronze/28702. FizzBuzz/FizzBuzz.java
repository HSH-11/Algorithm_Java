import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = 0;
		for (int i = 0; i < 3; i++) {
			String str = br.readLine();
			if (str.charAt(0) != 'F' && str.charAt(0) != 'B') {
				num = Integer.parseInt(str) + 3 - i;
				break;
			}
		}

		if (num % 15 == 0) {
			System.out.println("FizzBuzz");
		} else if (num % 5 == 0) {
			System.out.println("Buzz");
		} else if (num % 3 == 0) {
			System.out.println("Fizz");
		} else {
			System.out.println(num);
		}
	}

}