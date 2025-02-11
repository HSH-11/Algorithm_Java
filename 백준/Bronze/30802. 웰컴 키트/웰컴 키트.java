import java.io.*;
import java.util.*;

public class Main {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] sizes = br.readLine().split(" ");
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		int cloths = 0;
		for (String size : sizes ) {
			int cnt = Integer.valueOf(size);
			if (cnt == 0) {
				continue;
			}
			else {
				cloths += cnt / t;
				if((cnt % t) != 0) {
					cloths++;
				}
			}
		}
		
		System.out.println(cloths);
		System.out.println(N / p +" "+ N % p);

	}
	
}