package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class UserIdUtil {

	public static String getUserId() {
			
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			
			String date = sdf.format(new Date());
			
			Random random = new Random();
			StringBuilder userId = new StringBuilder(date);
			
			String num = random.nextInt(1000)*9+1000 + "";
			
			userId.append(num);
			return userId.toString();
			
	}
}
