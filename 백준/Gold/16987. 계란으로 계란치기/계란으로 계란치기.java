import java.io.*;
import java.util.*;

public class Main {

	static class Egg {
		int durability, weight;

		Egg(int durability, int weight) {
			this.durability = durability;
			this.weight = weight;
		}
	}

	static Egg[] eggs;
	static int N;
	static int maxBroken = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		eggs = new Egg[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int durability = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			eggs[i] = new Egg(durability, weight);
		}

		dfs(0, 0);

		System.out.println(maxBroken);
	}

	static void dfs(int idx, int brokenCount) {
		// 현재 깨진 계란 수가 이미 최대면 더 탐색할 필요 없음
		if (brokenCount == N || idx == N) {
			maxBroken = Math.max(maxBroken, brokenCount);
			return;
		}

		// 현재 들고 있는 계란이 깨져있으면 다음 계란으로
		if (eggs[idx].durability <= 0) {
			dfs(idx + 1, brokenCount);
			return;
		}

		boolean hit = false; // 친 적이 있는지

		for (int j = 0; j < N; j++) {
			if (idx == j)
				continue;
			if (eggs[j].durability <= 0)
				continue;

			hit = true;

			// 현재 idx 계란으로 j 계란을 친다
			eggs[idx].durability -= eggs[j].weight;
			eggs[j].durability -= eggs[idx].weight;

			int newBroken = brokenCount;
			if (eggs[idx].durability <= 0)
				newBroken++;
			if (eggs[j].durability <= 0)
				newBroken++;

			dfs(idx + 1, newBroken);

			// 복구
			eggs[idx].durability += eggs[j].weight;
			eggs[j].durability += eggs[idx].weight;
		}

		// 칠 수 있는 계란이 없다면 그냥 다음 계란
		if (!hit) {
			dfs(idx + 1, brokenCount);
		}
	}
}