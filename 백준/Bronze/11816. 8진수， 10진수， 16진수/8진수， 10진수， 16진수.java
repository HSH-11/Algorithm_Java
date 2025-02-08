import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		if (input.startsWith("0x")){
			int decimal = Integer.parseInt(input.substring(2),16);
			System.out.print(decimal);
		}
		else if (input.startsWith("0") && input.length()>1) {
			int decimal = Integer.parseInt(input.substring(1),8);
			System.out.print(decimal);

		}else {
			int decimal = Integer.parseInt(input);
			System.out.print(decimal);
		}
		br.close();
	}
}