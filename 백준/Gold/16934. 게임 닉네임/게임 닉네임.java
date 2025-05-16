import java.io.*;
import java.util.*;

public class Main {

	static Trie root = new Trie();
	static Map<String, Integer> nameCount = new HashMap<>();

	static class Trie {
		Map<Character, Trie> children = new HashMap<>();
		int passCount = 0;
	}

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			insert(br.readLine());
		}

		System.out.print(sb);
	}

	static void insert(String name) {
		Trie node = root;
		StringBuilder prefix = new StringBuilder();
		boolean printed = false;

		for (char ch : name.toCharArray()) {
			prefix.append(ch);
			if (!node.children.containsKey(ch)) {
				node.children.put(ch, new Trie());
			}
			node = node.children.get(ch);
			node.passCount++;

			if (!printed && node.passCount == 1) {
				sb.append(prefix).append("\n");
				printed = true;
			}
		}

		if (!nameCount.containsKey(name)) {
			nameCount.put(name, 1);
			if (!printed) sb.append(name).append("\n");
		} else {
			int count = nameCount.get(name) + 1;
			nameCount.put(name, count);
			sb.append(name).append(count).append("\n");
		}
	}
}