
import java.io.*;
import java.util.*;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int[] arr = new int[M];
		int total = 0;

		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			total += arr[i];
		}

		int K = Integer.parseInt(br.readLine());

		double result = 0;
		for(int i=0; i<M; i++){
            double value = 1;
            for(int j=0; j<K; j++){
                value *= ((double) (arr[i]-j) / (total-j));
            }
            result += value;
        }
		
		System.out.println(result);

	}

}
