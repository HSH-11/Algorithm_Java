import java.io.*;
import java.util.*;

// 문제 정의
// 한 번호가 다른 번호의 접두어인 경우가 없어야 한다. 있으면 "NO", 없으면 "YES"

// 문제 아이디어
// 트라이로 구현하는데 전화번호들을 트라이에 하나씩 삽입하면서 조건을 체크
// 각 노드는 숫자(0~9)를 기준으로 가지를 가짐.
// 삽입 도중에 이미 isEnd == true인 노드를 지나가면, 그 노드는 기존에 삽입된 번호의 끝이므로 누군가의 접미어가 되어서 일관성 깨진다.
// 삽입이 끝난 후에, 현재 노드 아래에 다른 자식 노드가 있으면, 누군가의 접두어가 되어 불일치

// Pseudo Code
// 노드 클래스 생성(HashMap으로 character,Node) child;, boolean isEnd;
// 트라이 클래스 생성- 메서드는 insert만 구현
// insert():
//	한 자리씩 따라가면서
//	해당 자식 노드가 없으면 새로 만든다.
//	if (현재 노드가 isEnd == true):
//		기존에 끝난 번호가 지금 삽입 중인 번호의 접두어
// 모두 삽입하고 나서
// 지금 노드에 자식 노드가 남아 있다면:
//	지금 삽입한 번호가 다른 번호의 접두어

public class Main {

	static class Node {
		Node[] child;
		boolean isEnd;

		public Node() {
			this.child = new Node[10];
			this.isEnd = false;
		}
	}

	static boolean insert(Node root, String str) {
		// 시작 노드를 루트노드로 설정(루트노드에는 값이 없음)
		Node node = root;

		for (int i = 0; i < str.length(); i++) {
			int num = str.charAt(i) - '0';
			if (node.isEnd) {
				// 기존 번호가 내 접두어임
				return false;
			}
			
			if (node.child[num] == null) {
				node.child[num] = new Node();
			}
			node = node.child[num];
		}

		// 지금 내가 다른 번호의 접두어라면
		for (int i = 0; i < 10; i++) {
			if (node.child[i] != null) {
				return false;
			}
		}
		// 삽입이 다 된 번호의 끝 표시
		node.isEnd = true;
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			Node node = new Node();
			boolean flag = true;

			for (int i = 0; i < N; i++) {
				String number = br.readLine();
				if (!insert(node, number)) {
					flag = false;
				}
			}

			if (flag) {
				sb.append("YES").append("\n");
			} else {
				sb.append("NO").append("\n");
			}

		}
		System.out.println(sb);
	}

}