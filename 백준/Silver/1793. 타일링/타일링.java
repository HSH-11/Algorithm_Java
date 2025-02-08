import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String T;
		BigInteger[] dp = new BigInteger[251];
		dp[0] = BigInteger.ONE;
		dp[1] = BigInteger.ONE;
		dp[2] = new BigInteger("3");
		
		for (int i = 3; i <= 250; i++) {
			dp[i] = dp[i-1].add(dp[i-2].multiply(new BigInteger("2")));
		}
		while((T = br.readLine()) != null && !T.isEmpty()) {
			int n = Integer.parseInt(T);
			System.out.println(dp[n]);
		}
		br.close();
		
	}
}