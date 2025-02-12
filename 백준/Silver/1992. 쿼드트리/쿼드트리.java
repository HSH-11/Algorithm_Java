import java.io.*;

public class Main {
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        arr = new int[N][N];
        
        for (int i = 0; i < N; i++) {
        	String st = br.readLine();
        	for (int j = 0; j < N; j++) {
        		int num = st.charAt(j)-'0';
        		arr[i][j] = num;
        	}
        }
        
        compress(0,0,N);
        System.out.println(sb);
	}
	
	static void compress(int x, int y, int size) {
		
		int pivot = arr[x][y];
		boolean flag = true;
		
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (arr[i][j] != pivot) {
					flag =  false;
					break;
				}
			}
			if (!flag) break;
		}
		
		if (flag) {
			sb.append(pivot);
			return;
		}
		
		sb.append("(");
		int n = size / 2;
		compress(x,y,n);
		compress(x,y+n,n);		
		compress(x+n,y,n);
		compress(x+n,y+n,n);
		sb.append(")");
	}
}