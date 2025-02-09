import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        System.out.println(pascal(N,K));
        
        br.close();
        
        

	}
	static int pascal(int n, int k) {
		if (n==k || k == 0) return 1;
		return pascal(n-1,k-1) + pascal(n-1,k);
	}
}