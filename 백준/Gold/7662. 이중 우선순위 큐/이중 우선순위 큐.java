import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int k = Integer.parseInt(br.readLine());

			TreeMap<Integer, Integer> map = new TreeMap<>();

			for (int j = 0; j < k; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String op = st.nextToken();
				int num = Integer.parseInt(st.nextToken());

				if (op.equals("I")) {
					map.put(num, map.getOrDefault(num, 0) + 1);
				} else if (op.equals("D")) {
					if (!map.isEmpty()) {
						int tgt = 0;
						if (num == 1) {
							tgt = map.lastKey();
						} else if (num == -1) {
							tgt = map.firstKey();
						}
						map.put(tgt, map.get(tgt) - 1);
						if (map.get(tgt) == 0) {
							map.remove(tgt);
						}
					}
				}
			}

			if (map.isEmpty()) {
				sb.append("EMPTY").append("\n");
			} else {
				sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
			}
		}
		System.out.print(sb.toString());
	}
}