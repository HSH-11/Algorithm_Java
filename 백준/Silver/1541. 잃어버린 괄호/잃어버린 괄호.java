import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 그리디 문제
// '-'기준으로 나누면, 그 이후의 값들은 전부 괄호로 묶어서 빼는 게 최소값임

// 해결 방법
// '-'기준 파싱
// 이 문제를 못 푼 이유: split("+")을 사용해서 하... 이걸 왜 눈치 못챘을까 그야 미흡했으니까
// "+"문자를 일반 문자로 그대로 인식하게 하려면 \를 붙여야하는데 \도 특수 문자이므로 \\해야함


public class Main {

	static int result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] groups = br.readLine().split("-");
		
		result += add(groups[0]);
		
		for (int i = 1; i < groups.length; i++) {
			result -= add(groups[i]);
		}
		
		System.out.println(result);
		
		}
			
		
	static int add(String s) {
		int sum = 0;
		String[] numbers = s.split("\\+");
		
		for (String num : numbers) {
			sum += Integer.parseInt(num);
		}
		
		return sum;
	}


}