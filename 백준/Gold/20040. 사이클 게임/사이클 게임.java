import java.io.*;
import java.util.*;

public class Main {

	static int[] parent;
	static byte[] rank;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		parent = new int[n];
		rank = new byte[n];

		for (int i = 0; i < n; i++)
			parent[i] = i;

		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (!union(a, b)) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(0);
	}

	static int find(int x) {
		while (parent[x] != x) {
			parent[x] = parent[parent[x]];
			x = parent[x];
		}

		return x;
	}

	static boolean union(int a, int b) {
		int ra = find(a);
		int rb = find(b);

		if (ra == rb)
			return false;

		if (rank[ra] < rank[rb]) {
			int tmp = ra;
			ra = rb;
			rb = tmp;
		}
		parent[rb] = ra;
		if (rank[ra] == rank[rb])
			rank[ra]++;
		return true;
	}

}