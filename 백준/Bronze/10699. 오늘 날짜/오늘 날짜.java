import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Main {

	public static void main(String[] args) throws IOException {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
		df.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
		System.out.println(df.format(date));
	}
}