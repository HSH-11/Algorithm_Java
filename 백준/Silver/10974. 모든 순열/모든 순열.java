import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {

	static int[] arr;
	static int N;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		

		for (int i = 0; i < N; i++) {
			arr[i] = i+1;
		}
		
		for (int num : arr) {
			sb.append(num+" ");
		}
		sb.append("\n");
		
		while(true) {	
			if(!np()) break;
			for (int num : arr) {
				sb.append(num+" ");
			}
			sb.append("\n");
			}
		System.out.println(sb);
		}
		
	static boolean np() {
		//꺾이는 부분 찾기
		int i = arr.length - 1;
		while( i > 0 && arr[i] <= arr[i-1]) --i;
		
		//맨앞까지 옴
		if (i == 0) return false;
		
		//src[i]이후 항목과 src[i-1]항목 비교 필요
		int j = arr.length - 1;
		while( arr[i-1] >= arr[j]) --j;
		//arr[i-1]보다 큰 항목 찾아 swap
		swap(i-1,j);
		
		//바꿨으면 i부터 맨 뒤까지 오름차순 정렬
		int k =  arr.length - 1;
		while( i < k ) {
			swap(i++,k--);
		}
		return true;
	}
	
	
	static void swap(int i ,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}