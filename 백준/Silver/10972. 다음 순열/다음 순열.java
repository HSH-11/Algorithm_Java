import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Main {

	static int[] arr;
	static int N;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if (np()) {
			for (int num: arr) {
				sb.append(num).append(" ");
			}
		}else {
			sb.append("-1");
		}
		
		System.out.println(sb);

		
	}
	
	static boolean np() {
		int i = arr.length-1;
		
		//주어진 배열을 뒤에서부터 탐색하면서 앞 숫자가 더 작은 위치(i-1) 꺾이는 부분 찾기
		while (i > 0 && arr[i-1] >= arr[i]) i--;
		
		//마지막 순열이면 -1 반환
		if (i == 0) return false;
		
		//다시 뒤에서 탐색하면 arr[i-1]보다 큰 값 j를 찾아 스왑
		int j = arr.length - 1;
		while(arr[i-1] >= arr[j]) j--;
		swap(i-1,j);
		
		
		//i이후의 배열을 오름차순 정렬(=뒤집기)
		int k = arr.length - 1;
		while(i<k) {
			swap(i++,k--);
		}
		return true;
	}
	
	static void swap(int i , int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	

}