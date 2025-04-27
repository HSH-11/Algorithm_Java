import java.io.*;
import java.util.*;

public class Main {

	static Trie root = new Trie();

	static class Trie {
		Map<String, Trie> children;

		Trie() {
			children = new TreeMap<String, Main.Trie>();
		}
	}

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			
			insert(br.readLine());

		}
		
		traversal(root,0);
		System.out.println(sb);
	}

	static void insert(String path) {
		Trie curr = root;

		String[] paths = path.split(" ");
		int k = Integer.parseInt(paths[0]);
		
		for (int j = 1; j < k + 1; j++) {
			if (!curr.children.containsKey(paths[j])) {
				curr.children.put(paths[j], new Trie());
			}

			curr = curr.children.get(paths[j]);
		}
	}
	
	
	static void traversal(Trie curr, int depth) {
		for (Map.Entry<String, Trie> entry : curr.children.entrySet()) {
			sb.append("--".repeat(depth)+entry.getKey()).append("\n");
			traversal(entry.getValue(),depth+1);
		}
	}

}