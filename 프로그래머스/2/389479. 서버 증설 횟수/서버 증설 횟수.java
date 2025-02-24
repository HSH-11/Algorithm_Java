import java.util.ArrayDeque;
import java.util.Queue;
class Solution {
   static Queue<Integer> queue = new ArrayDeque<>();
	static int cnt = 0;

	public static int solution(int[] players, int m, int k) {

		for (int time = 0; time < players.length; time++) {
			while(!queue.isEmpty() && queue.peek() <= time) {
				queue.poll();
			}
			
			int need = players[time] / m;
			int run = queue.size();
			while(run < need) {
				queue.offer(time+k);
				run++;
				cnt++;
			}
		}
		return cnt;
	}
}