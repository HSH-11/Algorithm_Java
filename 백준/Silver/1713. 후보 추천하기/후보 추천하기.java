// 커스텀 정렬
// 시간 관리

import java.io.*;
import java.util.*;

public class Main {

	static class Student implements Comparable<Student> {
		int number;
		int count;
		int time;

		public Student(int number, int time) {
			this.number = number;
			this.time = time;
			this.count = 1;
		}

		@Override
		public int compareTo(Student o) {
			// 추천 수가 적은 것
			if (this.count != o.count) {
				return this.count - o.count;
			}
			// 오래된 학생
			return this.time - o.time;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int recommendCount = Integer.parseInt(br.readLine());
		int[] recommends = new int[recommendCount];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < recommendCount; i++) {
			recommends[i] = Integer.parseInt(st.nextToken());

		}

		List<Student> frame = new ArrayList<Main.Student>();
		Map<Integer, Student> map = new HashMap<Integer, Main.Student>();
		int time = 0;

		for (int i = 0; i < recommendCount; i++) {
			int num = recommends[i];
			time++;

			// 이미 게시된 학생인지 파악
			if (map.containsKey(num)) {
				map.get(num).count++;
				continue;
			}

			// 게시가 안 된 학생인데 사진들이 가득 찼으면 제거
			if (frame.size() == N) {
				Collections.sort(frame); // 추천 수 & 오래된 순으로 정렬
				Student remove = frame.remove(0);
				map.remove(remove.number);

			}

			// 새로 게시
			Student newStudent = new Student(num, time);
			frame.add(newStudent);
			map.put(num, newStudent);
		}

		// 학생 번호로만 오름차순
		List<Integer> result = new ArrayList<Integer>();
		for (Student s : frame) {
			result.add(s.number);
		}

		Collections.sort(result);
		for (int num : result) {
			System.out.print(num + " ");
		}

	}
}
