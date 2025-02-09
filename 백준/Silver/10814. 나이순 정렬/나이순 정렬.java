import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

	static class Person {
		int age;
		String name;

		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Person> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			int age = Integer.parseInt(str[0]);
			String name = str[1];
			list.add(new Person(age, name));
		}
		
		//객체 목록을 정렬할 때 유용
		list.sort(Comparator.comparingInt(p -> p.age));

		StringBuilder sb = new StringBuilder();
		for (Person p : list) {
			sb.append(p.age).append(" ").append(p.name).append("\n");
		}
		System.out.print(sb.toString());

	}

}