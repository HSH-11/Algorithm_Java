import java.io.*;
import java.util.*;

public class Main {

	// KMP 알고리즘을 사용하여 패턴이 나타나는 시작 인덱스를 찾는 함수
    public static List<Integer> kmp(String text, String pattern) {
        int[] lps = computeLPSArray(pattern);
        List<Integer> positions = new ArrayList<>();
        int i = 0, j = 0;
        int n = text.length();
        int m = pattern.length();

        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == m) {
                    positions.add(i - j);
                    j = lps[j - 1];
                }
            } else {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }
        return positions;
    }
	
	// LPS (Longest Prefix Suffix) 배열을 계산하는 함수
    public static int[] computeLPSArray(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0;
        int i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0)
                    len = lps[len - 1];
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String A = br.readLine();
		String B = br.readLine();

		List<Integer> startPositions = kmp(S, A);
		List<Integer> endPositions = kmp(S, B);

		Set<String> substrings = new HashSet<>();

		for (int start : startPositions) {
			for (int end : endPositions) {
				int endIndex = end + B.length();
				if (start <= end && endIndex <= S.length()) {
					String sub = S.substring(start, endIndex);
					if (sub.startsWith(A) && sub.endsWith(B)) {
						substrings.add(sub);
					}
				}
			}
		}

		System.out.println(substrings.size());
	}

}
