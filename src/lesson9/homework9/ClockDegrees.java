package lesson9.homework9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.regex.*;

public class ClockDegrees {
	public static void main(String[] args) {
	
		String s;
	//	String[] ss = {"11:11am","1.11iM","12 23 pM","11:11:11","1:11","23:75","12,12","12.12AM","11:11PM","11:11:11Am",""};
	//	int hour;
	//	int minute;
	//	double time = 15.5;
	//	double minuteDegrees;
	//	double hourDegrees;
///		int[] iii = null;

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			System.out.print("Enter time:");
			
//			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
//			LocalTime time = LocalTime.parse(br.readLine(), dtf);
//			System.out.println(time);
			
			Pattern p = Pattern.compile("\\d{1,2}[ :\\.,]{1}\\d{2}([ :\\.,]{1}\\d{2})?( ?(p|P|a|A)(m|M))?");
			Matcher m = p.matcher(s = br.readLine());
//			for (int i = 0; i < ss.length; i++) {
//				Matcher m = p.matcher(ss[i]);
//				System.out.print(ss[i]);
//				System.out.println(m.matches()?" подходит":" не подходит");
			System.out.println(s);
			if (!m.matches()) {
				System.out.println(s + " - Неизвестный формат времени!");
			} else {
				int[] iii = Arrays.stream(s.split("[ :\\.,]{1}"))
						.mapToInt(Integer::parseInt)
						.toArray();
				
				for (int i = 0; i < iii.length; i++) {
					System.out.println(iii[i]);
				}
				System.out.println(Arrays.toString(iii));
				
//				String[] sss = ss[i].split("[ :\\.,]{1}\\");
//				System.out.println(Arrays.toString(sss));
////				for (int i = 0; i < sss.length; i++) {
////					iii[i] = Integer.parseInt(sss[i]);
////				}
//			}
			}
//			
////			String str = br.readLine();
////			hour = (int) time;
////			minute = 30;
////			minuteDegrees = getDegrees(minute);
////			hourDegrees = getDegrees(time);
		} catch (IOException e) {
			e.printStackTrace();
		}
//		System.out.println(hour);
//		System.out.println(minute);
//		System.out.println(minuteDegrees);
//		System.out.println(hourDegrees);

	}

	private static double getDegreesH;
	private static double getDegreesHM;
	private static double getDegreesHMS;
	private static double getDegreesM;
	private static double getDegreesMS;
	private static double getDegreesS;

	public static void getDegreesBetwenHourAndMinute(Long time) {

	}

	public static void getDegreesBetwenMinuteAndSecond(Long time) {

	}

	public static void getDegreesBetwenHourAndSecond(Long time) {

	}
}