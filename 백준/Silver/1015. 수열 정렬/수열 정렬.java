import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] original = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			original[i] = arr[i];
		}

		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(new int[] { arr[i], i }); // 인덱스 기억해주기
		}

		list.sort(Comparator.comparingInt(o -> o[0])); // 오름차순 정렬

		int[] result = new int[N];
		for (int i = 0; i < N; i++) {
			result[list.get(i)[1]] = i;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(result[i]).append(" ");
		}
		System.out.println(sb.toString().trim());
	}
}