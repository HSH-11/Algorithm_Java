import java.io.*;
import java.util.*;

public class Main {

	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		// 진실을 아는 사람들 저장
		st = new StringTokenizer(br.readLine());
		int truthCount = Integer.parseInt(st.nextToken());
		int[] truth = new int[truthCount];
		for (int i = 0; i < truthCount; i++) {
			truth[i] = Integer.parseInt(st.nextToken());
		}

		List<int[]> parties = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			// 각 파티에 참석한 사람들 저장
			int[] people = new int[k];
			for (int j = 0; j < k; j++) {
				people[j] = Integer.parseInt(st.nextToken());
			}
			parties.add(people);
			// 같은 파티에 있는 사람들은 모두 같은 집합으로 합침
			for (int j = 1; j < k; j++) {
				union(people[0], people[j]);
			}
		}

		// 진실 아는 사람 집합 루트
		Set<Integer> truthRoots = new HashSet<Integer>();
		for (int t : truth) {
			truthRoots.add(find(t));
		}
		int result = 0;
		for (int[] party : parties) {
			boolean canLie = true;
			for (int person : party) {
				if (truthRoots.contains(find(person))) {
					canLie = false;
					break;
				}
			}
			if (canLie)
				result++;
		}

		System.out.println(result);

	}

	static int find(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);
	}

	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA != rootB) {
			parent[rootB] = rootA;
		}
	}
}
