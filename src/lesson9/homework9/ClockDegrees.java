package lesson9.homework9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.*;

public class ClockDegrees {
	public static void main(String[] args) {
	
		String s;
	//	String[] ss = {"11:11am","1.11aM","12 23 pM","11:11:11","1:11","23:75","12,12","12.12AM","11:11PM","11:11:11Am"};
	//	int hour;
	//	int minute;
	//	double time = 15.5;
	//	double minuteDegrees;
	//	double hourDegrees;
		ArrayList<String> iii = new ArrayList<>();
		ArrayList<Integer> ii2 = new ArrayList<>();
		

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			System.out.print("Enter time:");
			
			Pattern p = Pattern.compile("\\d{1,2}[ :\\.,]{1}\\d{2}([ :\\.,]{1}\\d{2})?( ?(p|P|a|A)(m|M))?");
			Matcher m = p.matcher(s = br.readLine());
//			for (int i = 0; i < s.length(); i++) {
//								Matcher m = p.matcher(ss[i]);
//			}
//				System.out.print(ss[i]);
			System.out.print(s);
			System.out.println(m.matches()?" подходит":" не подходит");
			Pattern p1 = Pattern.compile("\\d+");
			Matcher m1 = p1.matcher(s); 
			while (m1.find()) {
			   iii.add(m1.group());
			   ii2.add(Integer.valueOf(m1.group()));
			}
			System.out.println(iii);
//			while (m1.find()) {
//				   ii2.add(Integer.valueOf(m1.group()));
//				}
			System.out.println(ii2);
			
//			if (!m.matches()) {
//				System.out.println(s + " - Неизвестный формат времени!");
//			} else {
//				/*int[] iii = */Arrays.stream(s.split("[ :\\.,]*|\\D*"))
//						.mapToInt(Integer::parseInt)
//						/*.toArray(); //Exception in thread "main" java.lang.NumberFormatException: For input string: "" */
//						.forEach(System.out::println);
//				/*for (int i = 0; i < iii.length; i++) {
//					System.out.println(iii[i]);
//				}
//				System.out.println(Arrays.toString(iii));*/
//				
////				String[] sss = ss[i].split("[ :\\.,]{1}\\");
////				System.out.println(Arrays.toString(sss));
//////				for (int i = 0; i < sss.length; i++) {
//////					iii[i] = Integer.parseInt(sss[i]);
//////				}
////			}
//			}
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