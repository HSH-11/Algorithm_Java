import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int set = 0;

		for (int i = 0; i < M; i++) {
			String cmd = br.readLine();
			if (cmd.startsWith("add")) {
				int x = Integer.parseInt(cmd.split(" ")[1]);
				set |= (1 << (x - 1));
			} else if (cmd.startsWith("remove")) {
				int x = Integer.parseInt(cmd.split(" ")[1]);
				set &= ~(1 << (x - 1));
			} else if (cmd.startsWith("check")) {
				int x = Integer.parseInt(cmd.split(" ")[1]);

				if ((set & (1 << (x - 1))) != 0) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
			} else if (cmd.startsWith("toggle")) {
				int x = Integer.parseInt(cmd.split(" ")[1]);
				if ((set & (1 << (x - 1))) != 0) {
					set &= ~(1 << (x - 1));
				} else {
					set |= (1 << (x - 1));
				}
			} else if (cmd.equals("all")) {
				set = (1 << 20) - 1;
			} else if (cmd.equals("empty")) {
				set = 0;
			}

		}
		System.out.println(sb.toString());

	}

}