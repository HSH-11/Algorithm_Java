import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

        int N = Integer.parseInt(br.readLine());
        int[] ipList = new int[N];

        // IP 주소 정수 변환
        for (int i = 0; i < N; i++) {
            String[] parts = br.readLine().split("\\.");
            int ip = 0;
            for (int j = 0; j < 4; j++) {
                ip |= Integer.parseInt(parts[j]) << (24 - 8 * j);
            }
            ipList[i] = ip;
        }


        // 최솟값, 최댓값 계산
        int min = ipList[0];
        int max = ipList[0];
        for (int ip : ipList) {
            min = Math.min(min, ip);
            max = Math.max(max, ip);
        }

        // 다른 비트 구하기
        int diff = min ^ max;

        // 몇 비트가 다른지 구하기
        int shift = 32 - Integer.numberOfLeadingZeros(diff);
        int mask = (shift == 32) ? 0x00000000 : ~((1 << shift) - 1);

        int network = ipList[0] & mask;

        PrintIP(network);
        PrintIP(mask);


        System.out.print(sb);
    }

    static void PrintIP(int ip) {
        sb.append((ip >> 24) & 0xFF).append(".")
          .append((ip >> 16) & 0xFF).append(".")
          .append((ip >> 8) & 0xFF).append(".")
          .append(ip & 0xFF).append("\n");
    }
}
