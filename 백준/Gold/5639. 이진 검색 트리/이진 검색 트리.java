import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public static void postOrder(Node root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.value);
    }

    public static Node find_original(int[] input, int start, int end) {
        if (start > end) return null;

        Node root = new Node(input[start]);
        int index;
   
        for (index = start + 1; index <= end; index++) {
            if (input[index] > root.value) break;
        }

        root.left = find_original(input, start + 1, index - 1);
        root.right = find_original(input, index, end);

        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        String line;
        
        while ((line = br.readLine()) != null && !line.isEmpty()){
        	sb.append(line).append(" ");
        }
        
        String[] nodes = sb.toString().split(" ");
        
        int n = nodes.length;
        int[] input = new int[n];
        
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(nodes[i]);
        }
        
        Node root = find_original(input, 0, n - 1);

        postOrder(root);
    }
}