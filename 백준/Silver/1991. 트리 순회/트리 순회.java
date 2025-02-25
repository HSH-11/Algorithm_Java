import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int N;
	
	static class Node {
		char data;
		Node left;
		Node right;
		
		Node(char data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	//트리 형성
	static Map<Character, Node> tree = new HashMap<>();
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			char parent =  input[0].charAt(0);
			char left =  input[1].charAt(0);
			char right =  input[2].charAt(0);
			
			//부모노드가 없으면 생성
			tree.putIfAbsent(parent, new Node(parent));
			
			//왼쪽 자식이 있으면 생성 후 연결
			if (left != '.') {
				tree.putIfAbsent(left, new Node(left));
				tree.get(parent).left = tree.get(left); //부모의 왼쪽에 자식 연결
			}
			
			if (right != '.') {
				tree.putIfAbsent(right, new Node(right));
				tree.get(parent).right = tree.get(right);
			}
		}
		
		Node root = tree.get('A'); // root는 항상 A
		
		preorder(root);
		System.out.println();
		inorder(root);
		System.out.println();
		postorder(root);
		
		
	}
	
	static void preorder(Node node) {
		if ( node == null) {
			return ;
		}
		System.out.print(node.data);
		preorder(node.left);
		preorder(node.right);
	}
	
	static void inorder(Node node) {
		if ( node == null) {
			return ;
		}
		inorder(node.left);
		System.out.print(node.data);	
		inorder(node.right);
	}
	
	static void postorder(Node node) {
		if ( node == null) {
			return ;
		}	
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.data);
	}
}