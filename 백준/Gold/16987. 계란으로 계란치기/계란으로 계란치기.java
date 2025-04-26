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
	static int maxBroken;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		eggs = new Egg[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			eggs[i] = new Egg(d, w);
		}

		dfs(0);
		
		System.out.println(maxBroken);

	}
	
	static void dfs(int idx) {
		// 모든 계란을 다 든 경우
		if (idx == N) {
			int broken = 0;
			for (int i = 0; i < N; i++) {
				if (eggs[i].durability <= 0) broken++;
			}
			maxBroken = Math.max(maxBroken, broken);
			return;
		}
		
		
		
		// 현재 계란이 깨져버리면 다음 계란으로
		if (eggs[idx].durability <= 0) {
			dfs(idx+1);
			return;
		}
		
		boolean canHit = false; // 때릴 수 있는 계란이 있는지 
		
		for (int j = 0; j < N; j++) {
			if (idx == j) continue; // 자기 계란 패스
			if (eggs[j].durability <= 0) continue; // 깨진 계란 패스
			
			canHit = true;
			
			// idx 계란으로 j번째 계란 치기
			eggs[idx].durability -= eggs[j].weight;
			eggs[j].durability -= eggs[idx].weight;
			
			dfs(idx + 1);
			
			eggs[idx].durability += eggs[j].weight;
			eggs[j].durability += eggs[idx].weight;
		}
		
		// 더 이상 칠 수 있는 계란이 하나도 없으면 그냥 다음 계란으로 계속 넘김
		if (!canHit) {
			dfs(idx + 1);
		}
	}

}