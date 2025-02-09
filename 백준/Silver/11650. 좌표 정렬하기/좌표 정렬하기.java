import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] points = new int[n][2];
		
		

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			points[i][0] = Integer.parseInt(st.nextToken());
			points[i][1] = Integer.parseInt(st.nextToken());
			
		}
		
		Arrays.sort(points,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return Integer.compare(o1[1], o2[1]);
				}
				return Integer.compare(o1[0], o2[0]);
			}
			
		});
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(points[i][0]).append(" ").append(points[i][1]).append("\n");
		}
		System.out.println(sb.toString());

	}

}