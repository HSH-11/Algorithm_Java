import java.io.*;
import java.util.*;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int twosComplement = ~N+1;
		int answer = Integer.bitCount(N ^ twosComplement);//x에서 1의 개수를 세어 반환
		
		System.out.println(answer);
		
				
	}
	
	

}